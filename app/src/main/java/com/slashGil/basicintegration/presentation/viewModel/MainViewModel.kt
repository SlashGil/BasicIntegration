package com.slashGil.basicintegration.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slashGil.basicintegration.domain.useCase.GetProductsUseCase
import com.slashGil.basicintegration.presentation.data.ProductUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.slashGil.basicintegration.core.Result

@HiltViewModel
class MainViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

    private val _productUiState = MutableLiveData<ProductUiModel>()

    val productUiState: LiveData<ProductUiModel>
        get() = _productUiState

    fun getProducts() {

    }
}