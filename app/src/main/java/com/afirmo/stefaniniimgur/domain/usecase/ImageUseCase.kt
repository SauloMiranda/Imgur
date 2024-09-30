package com.afirmo.stefaniniimgur.domain.usecase

import com.afirmo.stefaniniimgur.data.repository.ImageRepository
import com.afirmo.stefaniniimgur.domain.model.Image

class ImagesUseCase(private val repository: ImageRepository){
    suspend operator fun invoke(): List<Image> = repository.getImages()
}
