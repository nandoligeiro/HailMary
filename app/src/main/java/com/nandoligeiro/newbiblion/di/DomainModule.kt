package com.nandoligeiro.newbiblion.di

import com.nandoligeiro.newbiblion.data.room.HailMaryDao
import com.nandoligeiro.newbiblion.data.room.datasource.ChaptersDataSource
import com.nandoligeiro.newbiblion.data.room.mapper.ChapterDataToDomainMapper
import com.nandoligeiro.newbiblion.data.room.repository.ChaptersRepositoryImpl
import com.nandoligeiro.newbiblion.datasource.room.datasource.ChaptersDataSourceImpl
import com.nandoligeiro.newbiblion.datasource.room.mapper.ChapterEntityToDataMapper
import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.chapter.mapper.ChapterDomainToUiMapper
import com.nandoligeiro.newbiblion.domain.chapter.repository.ChaptersRepository
import com.nandoligeiro.newbiblion.domain.chapter.usecase.ChaptersFromBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun providesChapterEntityToDataMapper() = ChapterEntityToDataMapper()

    @Provides
    fun providesChapterDataToDomainMapper() = ChapterDataToDomainMapper()

    @Provides
    fun providesChapterDomainToUiMapper() = ChapterDomainToUiMapper()


    @Provides
    fun providesChaptersDataSource(
        dao: HailMaryDao,
        chapterEntityToDataMapper: ChapterEntityToDataMapper
    ): ChaptersDataSource = ChaptersDataSourceImpl(dao, chapterEntityToDataMapper)

    @Provides
    fun providesChaptersRepository(
        chaptersDataSource: ChaptersDataSource,
        chapterDataToDomainMapper: ChapterDataToDomainMapper
    ): ChaptersRepository = ChaptersRepositoryImpl(
        chaptersDataSource,
        chapterDataToDomainMapper
    )

    @Provides
    fun providesChaptersFromBookUseCase(
        chaptersRepository: ChaptersRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ChaptersFromBookUseCase(
        chaptersRepository,
        coroutineContextProvider
    )
}
