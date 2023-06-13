package com.nandoligeiro.newbiblion.data.room.mapper

import com.nandoligeiro.newbiblion.data.room.model.ChapterDataModel
import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel

class ChapterDataToDomainMapper {
    fun toDomain(chapters: List<ChapterDataModel>) = chapters.map { input ->
        ChapterDomainModel(
            verses = input.verses
        )
    }
}
