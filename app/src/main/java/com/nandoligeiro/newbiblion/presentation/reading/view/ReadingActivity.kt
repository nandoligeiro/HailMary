package com.nandoligeiro.newbiblion.presentation.reading.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nandoligeiro.newbiblion.R
import com.nandoligeiro.newbiblion.presentation.reading.viewmodel.ReadingViewModel
import com.nandoligeiro.newbiblion.ui.components.VersesList
import com.nandoligeiro.newbiblion.ui.theme.Black
import com.nandoligeiro.newbiblion.ui.theme.Grey
import com.nandoligeiro.newbiblion.ui.theme.NewBiblionTheme
import com.nandoligeiro.newbiblion.ui.theme.Shapes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReadingActivity : ComponentActivity() {

    private val viewModel: ReadingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewBiblionTheme {

                Surface(
                    color = Black,
                    modifier = Modifier.fillMaxSize()

                ) {
                    VersesList(viewModel)
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewBiblionTheme {
        VersesList(viewModel())
    }
}