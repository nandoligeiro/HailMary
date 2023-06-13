package com.nandoligeiro.newbiblion.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nandoligeiro.newbiblion.datasource.room.entities.BookEntity
import com.nandoligeiro.newbiblion.datasource.room.entities.VerseEntity

@Database(
    entities = [BookEntity::class, VerseEntity::class],
    version = 1, exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun hailMaryDao(): HailMaryDao
}
