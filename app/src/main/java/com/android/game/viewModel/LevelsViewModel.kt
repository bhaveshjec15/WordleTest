package com.android.game.viewModel

import com.android.game.backend.models.Level
import com.android.game.backend.repository.LevelRepository
import com.android.game.backend.usecase.GetNextLevel
import com.android.game.backend.usecase.ResetLevels

class LevelsViewModel(
    private val levelRepository: LevelRepository,
    private val getNextLevel: GetNextLevel,
    private val resetLevels: ResetLevels,
) : BaseViewModel<LevelsViewModel.State>(State()) {
    data class State(
        val currentLevel: Level? = null,
        val lastLevelReached: Boolean = false,

        )

    init {
        updateLevel()
    }

    fun levelPassed() {
        currentState().currentLevel?.let { levelRepository.levelPassed(it) }
        updateLevel()
    }

    private fun updateLevel() {
        val nextLevel = getNextLevel.execute()
        if (nextLevel == null) {
            updateState { copy(lastLevelReached = true, currentLevel = null) }
            return
        }
        updateState {
            copy(currentLevel = nextLevel, lastLevelReached = false)
        }
    }

    fun reset() {
        resetLevels.execute()
        updateLevel()
    }
}