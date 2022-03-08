package com.android.game.backend.usecase

import com.android.game.backend.repository.LevelRepository

class ResetLevels(
    private val levelRepository: LevelRepository,
) {
    fun execute() {
        levelRepository.reset()
    }
}