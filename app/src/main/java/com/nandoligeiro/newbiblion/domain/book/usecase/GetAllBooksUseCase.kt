package com.nandoligeiro.newbiblion.domain.book.usecase

import com.nandoligeiro.newbiblion.domain.book.model.BookDomainModel
import com.nandoligeiro.newbiblion.domain.book.repository.AllBooksRepository
import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.abstration.usecase.BackgroundExecutingUseCase

class GetAllBooksUseCase(
    private var allBooksRepository: AllBooksRepository,
    coroutineContextProvider: CoroutineContextProvider
): BackgroundExecutingUseCase<String, Collection<BookDomainModel>>(coroutineContextProvider) {
    override fun executeInBackground(request: String):
            Collection<BookDomainModel> = allBooksRepository.books()

}