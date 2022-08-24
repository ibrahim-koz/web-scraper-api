package com.example.webscraperapi.domain.sanitizers

interface ISanitizer {
    fun sanitize(string: String): String
}