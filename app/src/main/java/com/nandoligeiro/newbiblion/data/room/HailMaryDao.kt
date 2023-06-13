package com.nandoligeiro.newbiblion.data.room

import androidx.room.Dao
import androidx.room.Query
import com.nandoligeiro.newbiblion.datasource.room.entities.VerseEntity
import com.nandoligeiro.newbiblion.domain.verse.model.VerseDomainModel

@Dao
interface HailMaryDao {
    @Query("SELECT * FROM texto where livro = :bookId")
    fun getChaptersFromBook(bookId: Int): List<VerseEntity>

}