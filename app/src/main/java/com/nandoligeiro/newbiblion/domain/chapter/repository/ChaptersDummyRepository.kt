package com.nandoligeiro.newbiblion.domain.chapter.repository

import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel

class ChaptersDummyRepository : ChaptersRepository {

    override fun chapters(bookId: Int): List<ChapterDomainModel> = listOf(
    )


}
