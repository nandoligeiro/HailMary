package com.nandoligeiro.newbiblion.domain.chapter.mapper

import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel
import com.nandoligeiro.newbiblion.presentation.reading.model.ChapterUiModel

class ChapterDomainToUiMapper {
    fun toUI(chapters: List<ChapterDomainModel>) =
        chapters.map { input ->
            ChapterUiModel(
                verses = input.verses
            )
        }
}
