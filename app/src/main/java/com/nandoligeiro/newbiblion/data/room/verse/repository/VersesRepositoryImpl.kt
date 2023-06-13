package com.nandoligeiro.newbiblion.data.room.verse.repository

import com.nandoligeiro.newbiblion.data.room.HailMaryDao
import com.nandoligeiro.newbiblion.domain.verse.model.VerseDomainModel
import com.nandoligeiro.newbiblion.domain.verse.repository.VersesRepository
import javax.inject.Inject

class VersesRepositoryImpl @Inject constructor(
    private val dao: HailMaryDao
) : VersesRepository {
    override fun verses(bookId: Int): List<VerseDomainModel> = listOf()

}


