package com.nandoligeiro.newbiblion.domain.verse.repository

import com.nandoligeiro.newbiblion.domain.verse.model.VerseDomainModel

interface VersesRepository {
    fun verses(bookId: Int): List<VerseDomainModel>

}