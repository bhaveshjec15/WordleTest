package com.android.game.backend.repository

import com.android.game.backend.models.Level

interface LevelRepository {
    fun getCurrentLevelNumber(): Long
    fun levelPassed(level: Level)
    fun reset()
}