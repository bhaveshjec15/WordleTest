package com.android.game.fixtures

import com.android.game.backend.models.Level
import com.android.game.backend.models.Word
import com.android.game.backend.repository.LevelRepository
import com.android.game.backend.repository.WordRepository

class TestWordRepository : WordRepository {
    val words = mutableListOf(Word("TITLE"), Word("TESTY"))
    override fun find(word: Word): Boolean {
        return words.contains(word)
    }

    override fun random(): Word {
        return Word("TESTY")
    }

    fun addWord(word: Word) = words.add(word)
    override fun getWordForLevel(currentLevelNumber: Long): Word {
        return words[currentLevelNumber.toInt() - 1]
    }

    override val lastLevel: Long
        get() = 2
}

class AllExistRepository : WordRepository {
    override fun find(word: Word): Boolean {
        return true
    }

    override fun random(): Word {
        return Word("TESTY")
    }

    override fun getWordForLevel(currentLevelNumber: Long): Word {
        TODO()
    }

    override val lastLevel: Long
        get() = 4
}

class TestLevelRepository : LevelRepository {
    var currentLevel = 1L
    override fun getCurrentLevelNumber(): Long {
        return currentLevel
    }

    override fun levelPassed(level: Level) {
        currentLevel = level.number + 1
    }

    override fun reset() {
        currentLevel = 1
    }
}