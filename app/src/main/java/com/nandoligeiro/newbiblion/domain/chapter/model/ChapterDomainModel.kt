package com.nandoligeiro.newbiblion.domain.chapter.model

import com.nandoligeiro.newbiblion.datasource.room.model.Verse

data class ChapterDomainModel(
    val verses: List<Verse>
)