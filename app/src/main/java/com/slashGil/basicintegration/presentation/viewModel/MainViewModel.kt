package com.slashGil.basicintegration.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.slashGil.basicintegration.domain.useCase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

}