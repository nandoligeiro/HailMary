package com.nandoligeiro.newbiblion.domain.chapter.repository

import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel

interface ChaptersRepository {
    fun chapters(bookId: Int): List<ChapterDomainModel>
}