package com.captainapps.wordz.backend.models

data class Guess(
    val word: Word,
    val wordStatus: WordStatus
)