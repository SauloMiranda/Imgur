package com.afirmo.stefaniniimgur.data.repository

import com.afirmo.stefaniniimgur.domain.model.Image

interface ImageRepository {
    suspend fun getImages(): List<Image>
}