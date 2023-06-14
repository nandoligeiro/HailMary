package com.nandoligeiro.newbiblion.presentation.reading.model

import com.nandoligeiro.newbiblion.datasource.room.model.Verse

data class ChapterUiModel(
    val verses: List<Verse>
)
