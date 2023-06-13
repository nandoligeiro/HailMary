package com.nandoligeiro.newbiblion.datasource.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros")
data class BookEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("ref")
    val ref: Int,
    @ColumnInfo("abreviatura") val abbreviation: String,
    @ColumnInfo("testamento") val testament: Int,
    @ColumnInfo("classe") val category: Int,
    @ColumnInfo("curto") val shortName: String,
    @ColumnInfo("genero") val gender: String,
    @ColumnInfo("comprido") val fullName: String
)
