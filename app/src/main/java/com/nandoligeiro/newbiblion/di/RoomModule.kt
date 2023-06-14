package com.nandoligeiro.newbiblion.di

import android.content.Context
import androidx.room.Room
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

    const val DB_NAME = "Biblion"
    const val DB_PATH = "database/biblion.db"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = Room.databaseBuilder(
        context = appContext,
        AppDatabase::class.java,
        DB_NAME
    ).createFromAsset(DB_PATH).build()

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.hailMaryDao()

}
