package com.nandoligeiro.newbiblion.domain.book.repository

import com.nandoligeiro.newbiblion.domain.book.model.BookDomainModel

class BooksDummyRepository : AllBooksRepository {

    override fun books(): Collection<BookDomainModel> = listOf(
        BookDomainModel(0, "Gênesis","Livro do Gênesis", "Gn", 0),
        BookDomainModel(1, "Êxodo","Livro do Êxodo", "Ex", 0)
    )
}
