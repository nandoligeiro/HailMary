package com.nandoligeiro.newbiblion.ui.components

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nandoligeiro.newbiblion.R
import com.nandoligeiro.newbiblion.datasource.room.model.Verse
import com.nandoligeiro.newbiblion.presentation.reading.viewmodel.ReadingViewModel
import com.nandoligeiro.newbiblion.ui.theme.Green
import com.nandoligeiro.newbiblion.ui.theme.NewBiblionTheme
import com.nandoligeiro.newbiblion.ui.theme.Shapes
import com.nandoligeiro.newbiblion.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VersesList(readingViewModel: ReadingViewModel) {

    readingViewModel.getChaptersFromBook(0)
    val chapters = readingViewModel.result.collectAsState()

    Column(
        modifier = Modifier
            .clip(shape = Shapes.large)
            .padding(8.dp, 24.dp, 8.dp, 8.dp)
            .background(Green)
            .fillMaxSize()

    ) {

        Image(
            painter = painterResource(id = R.drawable.v_table), contentDescription = null,
            alignment = Alignment.TopCenter
        )
        HorizontalPager(
            pageCount = chapters.value.size,
            modifier = Modifier.fillMaxSize()

        ) { page ->

            Column(
                modifier = Modifier
                    .clip(shape = Shapes.large)
            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .height(30.dp)
                        .fillMaxWidth()
                        .background(Green),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = "${page + 1}",
                        textAlign = TextAlign.Center,
                        style = Typography.bodyLarge,
                        )
                }

                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp, 4.dp, 16.dp, 4.dp)
                ) {
                    items(chapters.value[page].verses) { item ->
                        ClickOnItem(item)
                    }
                }
            }

        }
    }
}

@Composable
fun ClickOnItem(item: Verse) {
    val context = LocalContext.current

    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, item.verse, Toast.LENGTH_SHORT)
                    .show()
            })
    {
        Text(
            text = item.verseNumber.toString(),
            style = Typography.bodySmall,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
        Text(
            text = item.verse,
            style = Typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewBiblionTheme {
        VersesList(viewModel())
    }
}
