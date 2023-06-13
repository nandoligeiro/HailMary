package com.nandoligeiro.newbiblion.domain.abstration.exception

class UnknownDomainException(throwable: Throwable) : DomainException(throwable) {
    constructor(errorMessage: String) : this(Throwable(errorMessage))
}
