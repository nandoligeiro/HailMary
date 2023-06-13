package com.nandoligeiro.newbiblion.di

import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import com.nandoligeiro.newbiblion.domain.abstration.usecase.UseCaseExecutor
import com.nandoligeiro.newbiblion.presentation.abrstration.coroutine.AppCoroutineContextProvider
import com.nandoligeiro.newbiblion.presentation.abrstration.usecase.UseCaseExecutorProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArchitecturePresentationModule {
    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        AppCoroutineContextProvider()

    @Provides
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider = ::UseCaseExecutor
}
