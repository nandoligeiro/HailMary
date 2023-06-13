package com.nandoligeiro.newbiblion.data.room.repository

import com.nandoligeiro.newbiblion.data.room.datasource.ChaptersDataSource
import com.nandoligeiro.newbiblion.data.room.mapper.ChapterDataToDomainMapper
import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel
import com.nandoligeiro.newbiblion.domain.chapter.repository.ChaptersRepository
import javax.inject.Inject

class ChaptersRepositoryImpl @Inject constructor(
    private val chapterDataSource: ChaptersDataSource,
    private val chapterDataToDomainMapper: ChapterDataToDomainMapper
) : ChaptersRepository {
    override fun chapters(bookId: Int): List<ChapterDomainModel> =
        chapterDataToDomainMapper.toDomain(chapterDataSource.getChapters(bookId))
}


