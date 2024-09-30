package com.afirmo.stefaniniimgur

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.afirmo.stefaniniimgur.domain.model.Image

@Composable
fun ImageGallery(modifier: Modifier,images: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp)
    ) {

        items(images) { image ->
            val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = image)
                        .apply<ImageRequest.Builder>(block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.placeholder)
                        }).build()
                )
            Image(
                painter = painter,
                contentDescription = "Imagem de Gato",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageGalleryPreview() {
        val images =  mutableListOf<String>()
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")

        ImageGallery(Modifier, images = images)

}