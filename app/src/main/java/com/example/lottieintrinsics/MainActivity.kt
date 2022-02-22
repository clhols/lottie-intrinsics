package com.example.lottieintrinsics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieintrinsics.ui.theme.LottieIntrinsicsTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LottieIntrinsicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

          Column {
            Text(text = "Header")
            ContentWithLottieBackground()
            Text(text = "Footer")
            ContentWithImageBackground()
          }

        }
      }
    }
  }
}

@Composable
private fun ContentWithLottieBackground() {
  Box(modifier = Modifier.height(IntrinsicSize.Min)) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background))
    LottieAnimation(
      composition = composition,
      iterations = LottieConstants.IterateForever,
      contentScale = ContentScale.FillBounds,
    )

    Column {
      Text(text = "Hello")
      Text(text = "Lottie")
    }
  }
}

@Composable
private fun ContentWithImageBackground() {
  Box(modifier = Modifier.height(IntrinsicSize.Min)) {
    Image(
      painter = painterResource(id = R.drawable.ic_launcher_background),
      contentDescription = "",
      modifier = Modifier.fillMaxWidth(),
      contentScale = ContentScale.FillWidth
    )

    Column {
      Text(text = "Hello")
      Text(text = "World")
    }
  }
}