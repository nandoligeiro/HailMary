package com.nandoligeiro.newbiblion.data.room.datasource

import com.nandoligeiro.newbiblion.data.room.model.ChapterDataModel

interface ChaptersDataSource {
    fun getChapters(bookId: Int): List<ChapterDataModel>
}