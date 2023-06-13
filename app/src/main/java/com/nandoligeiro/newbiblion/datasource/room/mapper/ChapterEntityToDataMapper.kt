package com.nandoligeiro.newbiblion.datasource.room.mapper

import com.nandoligeiro.newbiblion.data.room.model.ChapterDataModel
import com.nandoligeiro.newbiblion.datasource.room.entities.VerseEntity
import com.nandoligeiro.newbiblion.datasource.room.model.Verse

class ChapterEntityToDataMapper {
    fun toData(verses: List<VerseEntity>): List<ChapterDataModel> {

        val record = mapVersesToChapter(verses)
        return record.map { input ->
            ChapterDataModel(
                verses = input.second
            )
        }
    }

    private fun mapVersesToChapter(
        verses: List<VerseEntity>
    ): List<Pair<Int, ArrayList<Verse>>> {

        val mapChapters: MutableMap<Int, ArrayList<Verse>> = HashMap()
        var versesByChapter: ArrayList<Verse> = ArrayList()

        var initialChapter = INITIAL_VALUE

        verses.forEach { item ->
            if (initialChapter == item.chapter) {
                versesByChapter.add(Verse(item.verse, item.verseDescription))
            } else {
                mapChapters[initialChapter - INITIAL_VALUE] = versesByChapter
                versesByChapter = ArrayList()
                initialChapter++
            }
        }
        mapChapters[initialChapter - INITIAL_VALUE] = versesByChapter
        return mapChapters.toList()
    }

    companion object {
        const val INITIAL_VALUE = 1
    }
}
