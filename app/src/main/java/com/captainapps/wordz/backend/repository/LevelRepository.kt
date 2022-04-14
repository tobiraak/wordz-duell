package com.captainapps.wordz.backend.repository

import com.captainapps.wordz.backend.models.Level

interface LevelRepository {
    fun getCurrentLevelNumber(): Long
    fun levelPassed(level: Level)
    fun reset()
}