package com.nandoligeiro.newbiblion.presentation.abrstration.usecase

import com.nandoligeiro.newbiblion.domain.abstration.usecase.UseCaseExecutor
import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider =
        @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
