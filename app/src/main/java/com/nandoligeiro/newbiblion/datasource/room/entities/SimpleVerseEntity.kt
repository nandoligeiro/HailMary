package com.nandoligeiro.newbiblion.datasource.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "texto")
data class SimpleVerseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("testamento") val testament: String,
    @ColumnInfo("classe") val category: String,
    @ColumnInfo("livro") val book: Int,
    @ColumnInfo("capitulo") val chapter: Int,
    @ColumnInfo("versiculo") val verse: Int,
    @ColumnInfo("texto") val verseDescription: String,

)