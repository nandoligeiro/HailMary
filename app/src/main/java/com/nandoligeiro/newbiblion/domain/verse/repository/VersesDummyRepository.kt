package com.nandoligeiro.newbiblion.domain.verse.repository

import com.nandoligeiro.newbiblion.domain.verse.model.VerseDomainModel


class VersesDummyRepository : VersesRepository {

    override fun verses(bookId: Int): List<VerseDomainModel> = listOf(
        VerseDomainModel(0, 1,"foqurequrioqurieouqoieruqoeruioqieuroiqueroiqueroiqueroiqueroiquroiqu"),
        VerseDomainModel(1, 2, "adajfklajerojeirjqoirjoiqjreoqjeriqjeriioureoquioeruqoeurioqueroiquroqiuer"),
        VerseDomainModel(2, 3, "adajfklajerojeirjqoirjoiqjreoqjeriqjeriioureoquioeruqoeurioqueroiquroqiuer")
    )

}
