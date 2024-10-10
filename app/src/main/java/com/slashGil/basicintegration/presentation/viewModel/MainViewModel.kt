package com.slashGil.basicintegration.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slashGil.basicintegration.domain.useCase.GetProductsUseCase
import com.slashGil.basicintegration.presentation.data.ProductUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.slashGil.basicintegration.core.Result
import com.slashGil.basicintegration.presentation.data.ProductUi
import com.slashGil.basicintegration.presentation.data.toProductUi
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class MainViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

    private val _productUiState = MutableLiveData<ProductUiModel>()

    val productUiState: LiveData<ProductUiModel>
        get() = _productUiState

    fun getProducts() {
        emitUiState(isLoading = true)
        viewModelScope.launch(IO) {
            val result = getProductsUseCase.invoke()
            withContext(Dispatchers.Main) {
                when(result) {
                    is Result.Success -> productSuccess(result.data.toProductUi())
                    is Result.Error -> productError(result.exception)
                }
            }
        }
    }

    private fun productSuccess(products: List<ProductUi>) {
        emitUiState(products = products)
    }

    private fun productError(exception: Exception) {
        emitUiState(exception = exception)
    }

    private fun emitUiState(isLoading: Boolean = false,
                            products: List<ProductUi> = emptyList(),
                            exception: Exception? = null) {
        val uiModel = ProductUiModel(isLoading, products, exception)
        _productUiState.value = uiModel
    }
}
