package com.example.webscraperapi.domain.sanitizers

class NonAlphanumericCharacterSanitizer: ISanitizer {
    private val re = Regex("[^A-Za-z0-9 ]")
    override fun sanitize(string: String) = re.replace(string, "")
}