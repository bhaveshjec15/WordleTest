package com.android.game.backend.repository

import com.android.game.backend.models.Word

interface WordRepository {
    val lastLevel: Long
    fun find(word: Word): Boolean
    fun random(): Word
    fun getWordForLevel(currentLevelNumber: Long): Word
}

