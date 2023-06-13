package com.nandoligeiro.newbiblion.domain.book.model

data class BookDomainModel (
        val id: Int,
        val shotName: String,
        val fullName: String,
        val abbreviation: String,
        val testament: Int)