package com.captainapps.wordz.backend.usecase

import com.captainapps.wordz.backend.models.Level
import com.captainapps.wordz.backend.repository.LevelRepository
import com.captainapps.wordz.backend.repository.WordRepository

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