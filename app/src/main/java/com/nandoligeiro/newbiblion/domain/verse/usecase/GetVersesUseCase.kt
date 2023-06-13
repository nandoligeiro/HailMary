package com.nandoligeiro.newbiblion.domain.verse.usecase

import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.abstration.usecase.BackgroundExecutingUseCase
import com.nandoligeiro.newbiblion.domain.verse.model.VerseDomainModel
import com.nandoligeiro.newbiblion.domain.verse.repository.VersesRepository

class GetVersesUseCase(
    private var versesRepository: VersesRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, List<VerseDomainModel>>(coroutineContextProvider) {
    override fun executeInBackground(request: Int):
            List<VerseDomainModel> = versesRepository.verses(request)

}