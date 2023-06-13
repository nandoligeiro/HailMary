package com.nandoligeiro.newbiblion.presentation.book

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nandoligeiro.newbiblion.ui.theme.NewBiblionTheme
import com.nandoligeiro.newbiblion.ui.components.VersesList
import com.nandoligeiro.newbiblion.ui.theme.Shapes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewBiblionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    shape = Shapes.large
                ) {
                    Box(Modifier.fillMaxSize(),
                        contentAlignment = Alignment.TopCenter) {
                        Canvas(
                            modifier = Modifier
                                .width(80.dp)
                                .height(50.dp),
                        ) {

                            val canvasWidth = size.width
                            val canvasHeight = size.height

                            drawArc(
                                Color.White,
                                startAngle = 180f,
                                sweepAngle = 180f,
                                useCenter = true,
                                size = Size(canvasWidth, 2 * canvasHeight)
                            )

                            val handleWidth = 200f
                            val handleHeight = 30f

                            drawRoundRect(
                                Color.Black,
                                size = Size(handleWidth, handleHeight),
                                cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx()),
                                topLeft = Offset(
                                    (canvasWidth - handleWidth) / 2,
                                    (canvasHeight - handleHeight) / 2
                                )
                            )

                        }
                    }
                    VersesList(viewModel())
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewBiblionTheme {
        VersesList(viewModel())
    }
}