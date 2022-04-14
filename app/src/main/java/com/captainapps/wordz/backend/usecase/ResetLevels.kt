package com.captainapps.wordz.backend.usecase

import com.captainapps.wordz.backend.repository.LevelRepository

class ResetLevels(
    private val levelRepository: LevelRepository,
) {
    fun execute() {
        levelRepository.reset()
    }
}