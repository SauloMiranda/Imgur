package com.afirmo.stefaniniimgur.data.dto

data class ImgurData(
    val `data`: List<Data>,
    val status: Int,
    val success: Boolean
)