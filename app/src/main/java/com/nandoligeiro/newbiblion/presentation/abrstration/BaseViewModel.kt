package com.nandoligeiro.newbiblion.presentation.abrstration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandoligeiro.newbiblion.domain.abstration.exception.DomainException
import com.nandoligeiro.newbiblion.domain.abstration.usecase.UseCase
import com.nandoligeiro.newbiblion.presentation.abrstration.usecase.UseCaseExecutorProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<anyState : Any>(
    useCaseExecutorProvider: UseCaseExecutorProvider
) : ViewModel() {

    private val mutableResult by lazy { MutableStateFlow(initialState()) }
    val result: StateFlow<anyState> get() = mutableResult

    protected abstract fun initialState(): anyState

    private val currentViewState: anyState
        get() = mutableResult.value

    private val useCaseExecutor by lazy {
        useCaseExecutorProvider(viewModelScope)
    }

    protected fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        execute(useCase, Unit, onSuccess, onException)
    }

    protected fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(useCase, value, onSuccess, onException)
    }

    protected fun updateViewState(newViewState: anyState) {
        mutableResult.value = newViewState
    }

    protected fun updateViewState(
        updatedState: anyState.() -> anyState
    ) = updateViewState(currentViewState.updatedState())

}
