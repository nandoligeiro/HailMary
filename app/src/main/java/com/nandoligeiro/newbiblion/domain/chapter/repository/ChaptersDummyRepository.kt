package com.nandoligeiro.newbiblion.domain.chapter.repository

import com.nandoligeiro.newbiblion.datasource.room.model.Verse
import com.nandoligeiro.newbiblion.domain.chapter.model.ChapterDomainModel

class ChaptersDummyRepository : ChaptersRepository {
    override fun chapters(bookId: Int): List<ChapterDomainModel> = listOf(
        ChapterDomainModel(listOf(Verse(1, "fdfdfdfdfdfdfd"))),
        ChapterDomainModel(listOf(Verse(2, "asdfadsfasdfasdfasdf"))),
    )
}
