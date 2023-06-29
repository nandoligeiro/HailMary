package com.nandoligeiro.newbiblion.domain.chapter.usecase

import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.abstration.usecase.BackgroundExecutingUseCase
import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel
import com.nandoligeiro.newbiblion.domain.chapter.repository.ChaptersRepository
import javax.inject.Inject

class ChaptersFromBookUseCase @Inject constructor(
    private var chaptersRepository: ChaptersRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, List<ChapterDomainModel>>(coroutineContextProvider) {
    override fun executeInBackground(request: Int): List<ChapterDomainModel> {
        return chaptersRepository.chapters(request)
    }
}
