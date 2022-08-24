package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import com.example.webscraperapi.domain.sanitizers.ISanitizer

interface IScraper {
    val sanitizer: ISanitizer
    fun scrape(data: String): CompanyInfo
}