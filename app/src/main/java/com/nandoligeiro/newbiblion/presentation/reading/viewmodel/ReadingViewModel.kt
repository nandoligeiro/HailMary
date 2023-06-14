package com.nandoligeiro.newbiblion.presentation.reading.viewmodel

import com.nandoligeiro.newbiblion.domain.chapter.usecase.ChaptersFromBookUseCase
import com.nandoligeiro.newbiblion.presentation.abrstration.BaseViewModel
import com.nandoligeiro.newbiblion.presentation.reading.model.ChapterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadingViewModel @Inject constructor(
    private val chaptersFromBookUseCase: ChaptersFromBookUseCase,
) : BaseViewModel() {

    private val _chapters = MutableStateFlow<List<ChapterUiModel>>(emptyList())
    val chapters: StateFlow<List<ChapterUiModel>> get() = _chapters

    fun getChaptersFromBook(bookId: Int) {
        launch {
            _chapters.value = chaptersFromBookUseCase.executeInBackground(bookId)
        }
    }
}