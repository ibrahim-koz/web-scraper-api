package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo

interface IScraper {
    fun scrape(data: String): CompanyInfo
}