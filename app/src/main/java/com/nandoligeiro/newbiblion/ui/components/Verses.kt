package com.nandoligeiro.newbiblion.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nandoligeiro.newbiblion.presentation.reading.ReadingViewModel
import com.nandoligeiro.newbiblion.ui.theme.NewBiblionTheme
import com.nandoligeiro.newbiblion.ui.theme.Orange20

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VersesList(readingViewModel: ReadingViewModel) {

    readingViewModel.getChaptersFromBook(0)
    val chapters = readingViewModel.chapters.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Orange20)
            .fillMaxSize(),
    ) {
        HorizontalPager(
            pageCount = chapters.value.size,
            Modifier.fillMaxSize(),
        ) { page ->
            Text(
                text = "Page $page",
                color = Color.White
            )
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(chapters.value[page].verses) { item ->

                    Row {
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = item.verseNumber.toString(),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = item.verse,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
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
