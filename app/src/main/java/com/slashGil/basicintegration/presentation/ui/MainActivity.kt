package com.slashGil.basicintegration.presentation.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.slashGil.basicintegration.databinding.ActivityMainBinding
import com.slashGil.basicintegration.presentation.adapter.ProductsAdapter
import com.slashGil.basicintegration.presentation.data.ProductUiModel
import com.slashGil.basicintegration.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val productsAdapter by lazy { ProductsAdapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        initUi()
        initObservers()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUi() {
        binding.productsRv.layoutManager = GridLayoutManager(this, 2)
        binding.productsRv.adapter = productsAdapter
    }

    private fun initObservers() {
        viewModel.productUiState.observe(this) { onProductsUiState(it) }
    }

    private fun onProductsUiState(uiModel: ProductUiModel) {
        binding.loading.isVisible = uiModel.isLoading
        productsAdapter.setProducts(uiModel.products)
        if(uiModel.exception != null)
            Toast.makeText(this, uiModel.exception.message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getProducts()
    }
}