package com.android.game.backend.usecase

import com.android.game.backend.models.Level
import com.android.game.backend.repository.LevelRepository
import com.android.game.backend.repository.WordRepository

class GetNextLevel(
    private val wordRepository: WordRepository,
    private val levelRepository: LevelRepository,
) {
    fun execute(): Level? {
        val currentLevelNumber = levelRepository.getCurrentLevelNumber()
        if (currentLevelNumber >= wordRepository.lastLevel + 1) return null
        return wordRepository.getWordForLevel(currentLevelNumber).let { word ->
            Level(currentLevelNumber, word)
        }
    }
}