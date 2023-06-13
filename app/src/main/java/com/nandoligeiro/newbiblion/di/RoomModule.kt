package com.nandoligeiro.newbiblion.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nandoligeiro.newbiblion.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private val MIGRATION_1_2 = object : Migration(1,2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE account ADD COLUMN client_alt_phone_on_route_sheets INTEGER NOT NULL DEFAULT(0)"
            )
        }
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        context = appContext,
        AppDatabase::class.java,
        "biblion")
        .createFromAsset("database/biblion.db").build()


    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.hailMaryDao()

}