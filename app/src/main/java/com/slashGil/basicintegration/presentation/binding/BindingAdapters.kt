package com.slashGil.basicintegration.presentation.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        this.load(url) {
            crossfade(true)
        }
    }
}