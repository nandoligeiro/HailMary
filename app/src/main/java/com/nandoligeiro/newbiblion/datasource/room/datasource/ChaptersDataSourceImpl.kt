package com.nandoligeiro.newbiblion.datasource.room.datasource

import com.nandoligeiro.newbiblion.data.room.HailMaryDao
import com.nandoligeiro.newbiblion.data.room.datasource.ChaptersDataSource
import com.nandoligeiro.newbiblion.data.room.model.ChapterDataModel
import com.nandoligeiro.newbiblion.datasource.room.mapper.ChapterEntityToDataMapper
import javax.inject.Inject

class ChaptersDataSourceImpl @Inject constructor(
    private val dao: HailMaryDao,
    private val chapterEntityToDataMapper: ChapterEntityToDataMapper
) : ChaptersDataSource {
    override fun getChapters(bookId: Int): List<ChapterDataModel> =
        chapterEntityToDataMapper.toData(dao.getChaptersFromBook(bookId))

}
