package com.nandoligeiro.newbiblion.domain.book.repository

import com.nandoligeiro.newbiblion.domain.book.model.BookDomainModel

interface AllBooksRepository {
    fun books(): Collection<BookDomainModel>

}