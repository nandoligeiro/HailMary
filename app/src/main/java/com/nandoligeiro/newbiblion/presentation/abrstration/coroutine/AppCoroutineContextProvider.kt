package com.nandoligeiro.newbiblion.presentation.abrstration.coroutine

import com.nandoligeiro.newbiblion.domain.abstration.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
