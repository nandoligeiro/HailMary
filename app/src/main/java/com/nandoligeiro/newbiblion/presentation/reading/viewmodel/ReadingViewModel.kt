package com.nandoligeiro.newbiblion.presentation.reading.viewmodel

import com.nandoligeiro.newbiblion.domain.chapter.mapper.ChapterDomainToUiMapper
import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel
import com.nandoligeiro.newbiblion.domain.chapter.usecase.ChaptersFromBookUseCase
import com.nandoligeiro.newbiblion.presentation.abrstration.BaseViewModel
import com.nandoligeiro.newbiblion.presentation.abrstration.usecase.UseCaseExecutorProvider
import com.nandoligeiro.newbiblion.presentation.reading.model.ChapterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReadingViewModel @Inject constructor(
    private val chaptersFromBookUseCase: ChaptersFromBookUseCase,
    private val chapterDomainToUiMapper: ChapterDomainToUiMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<List<ChapterUiModel>>(useCaseExecutorProvider) {

    fun getChaptersFromBook(bookId: Int) {
        execute(chaptersFromBookUseCase, bookId, ::presentChapters)
    }

    private fun presentChapters(chapters: List<ChapterDomainModel>) {
        val uiChapters = chapterDomainToUiMapper.toUI(chapters)
        updateViewState { uiChapters }
    }

    override fun initialState(): List<ChapterUiModel> = emptyList()
}
