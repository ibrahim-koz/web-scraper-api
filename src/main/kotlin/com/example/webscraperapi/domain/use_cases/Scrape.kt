package com.example.webscraperapi.domain.use_cases

import com.example.webscraperapi.domain.dto.CompanyInfo
import com.example.webscraperapi.domain.factory.ScraperPipelineFactory

val scraperPipelineFactory = ScraperPipelineFactory()

fun scrape(path: String): CompanyInfo {
    val scraperPipeline = scraperPipelineFactory.createPipeline(path)
    return scraperPipeline.start(path)
}
