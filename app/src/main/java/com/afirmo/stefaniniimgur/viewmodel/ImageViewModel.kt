package com.afirmo.stefaniniimgur.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afirmo.stefaniniimgur.data.repository.RetrofitInstance
import com.afirmo.stefaniniimgur.domain.model.Image
import com.afirmo.stefaniniimgur.domain.usecase.ImagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ImageViewModel: ViewModel() {
    private val _images = MutableStateFlow<List<String>>(emptyList())
    val images = _images.asStateFlow()

    init {
        fetchImages()
    }

    private fun fetchImages() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.fetchImages()
            _images.value = response.data.map { it.images.first().link }
        }
    }
}