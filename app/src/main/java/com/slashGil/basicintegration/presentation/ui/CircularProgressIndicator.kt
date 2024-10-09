package com.slashGil.basicintegration.presentation.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation.INFINITE
import android.view.animation.LinearInterpolator
import kotlin.math.min
import com.slashGil.basicintegration.R

class CircularProgressView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }

    private var progressColor = Color.BLUE
    private var strokeWidth = 10f
    private var currentRotation = 0f
    private val animation = ValueAnimator.ofFloat(0f, 360f).apply {
        duration = 1000
        repeatCount = INFINITE
        interpolator = LinearInterpolator()
        addUpdateListener {
            currentRotation = it.animatedValue as Float
            invalidate()
        }
    }

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressView)
        progressColor = typedArray.getColor(R.styleable.CircularProgressView_progressColor, progressColor)
        strokeWidth = typedArray.getDimension(R.styleable.CircularProgressView_strokeWidth, strokeWidth)
        typedArray.recycle()

        paint.color = progressColor
        paint.strokeWidth = strokeWidth
        startAnimation()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (min(width, height) / 2f) - strokeWidth / 2f

        canvas.rotate(currentRotation, centerX, centerY)
        canvas.drawCircle(centerX, centerY, radius, paint)
    }

    fun startAnimation() {
        animation.start()
    }

    fun stopAnimation() {
        animation.cancel()
    }

    fun setColor(color: Int) {
        progressColor = color
        paint.color = progressColor
        invalidate()
    }

    fun setStrokeWidth(width: Float) {
        strokeWidth = width
        paint.strokeWidth = strokeWidth
        invalidate()
    }
}