package com.nandoligeiro.newbiblion.domain.chapter.usecase

import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.abstration.usecase.BackgroundExecutingUseCase
import com.nandoligeiro.newbiblion.domain.chapter.mapper.ChapterDomainToUiMapper
import com.nandoligeiro.newbiblion.domain.chapter.repository.ChaptersRepository
import com.nandoligeiro.newbiblion.presentation.reading.model.ChapterUiModel
import javax.inject.Inject

class ChaptersFromBookUseCase @Inject constructor(
    private var chaptersRepository: ChaptersRepository,
    private val chapterDomainToUiMapper: ChapterDomainToUiMapper,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, List<ChapterUiModel>>(coroutineContextProvider) {
    override fun executeInBackground(request: Int): List<ChapterUiModel> {

        return chapterDomainToUiMapper.toUI(chaptersRepository.chapters(request))

    }


}
