package com.android.game.backend.usecase

import com.android.game.backend.models.Level
import com.android.game.backend.repository.LevelRepository
import com.android.game.backend.repository.WordRepository
import com.android.game.fixtures.TestLevelRepository
import com.android.game.fixtures.TestWordRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetNextLevelTest {
    private lateinit var testWordRepository: WordRepository
    private lateinit var testLevelRepository: LevelRepository

    @Before
    fun setUp() {
        testWordRepository = TestWordRepository()
        testLevelRepository = TestLevelRepository()
    }

    private fun createUseCase() = GetNextLevel(
        testWordRepository, testLevelRepository
    )

    @Test
    fun `getting next level gets the next word and creates a level`() {
        val useCase = createUseCase()
        val level1 = Level(1, testWordRepository.getWordForLevel(1))
        val level2 = Level(2, testWordRepository.getWordForLevel(2))
        assertEquals(level1, useCase.execute())
        testLevelRepository.levelPassed(level1)
        assertEquals(level2, useCase.execute())
    }

    @Test
    fun `getting the next level for last level returns null`() {
        val useCase = createUseCase()
        val level1 = Level(1, testWordRepository.getWordForLevel(1))
        val level2 = Level(2, testWordRepository.getWordForLevel(2))
        assertEquals(level1, useCase.execute())
        testLevelRepository.levelPassed(level1)
        assertEquals(level2, useCase.execute())
        testLevelRepository.levelPassed(level2)
        assertEquals(null, useCase.execute())
    }
}