package com.afirmo.stefaniniimgur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.afirmo.stefaniniimgur.ui.theme.StefaniniImgurTheme
import com.afirmo.stefaniniimgur.viewmodel.ImageViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        setContent {
            StefaniniImgurTheme {
                val images = imageViewModel.images.collectAsState()
                Scaffold(
                    topBar = {
                        CatGalleryAppBar()
                    },
                    content = { padding ->
                        ImageGallery(Modifier.padding(padding),images = images.value)
                    }
                )

            }
        }
    }
}

@Composable
fun CatGalleryAppBar() {
    TopAppBar(
        title = { Text("Cats") },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,

        elevation = 4.dp
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        val images =  mutableListOf<String>()
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")
        images.add("https://imgur.com/a/CbfAdOW")

        ImageGallery(Modifier, images = images)

}