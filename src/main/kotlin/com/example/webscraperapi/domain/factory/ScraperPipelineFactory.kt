package com.example.webscraperapi.domain.factory

import com.example.webscraperapi.domain.context.ScraperPipeline
import com.example.webscraperapi.domain.exceptions.RelevantScraperNotFoundException
import com.example.webscraperapi.domain.readers.HTTPFetcher
import com.example.webscraperapi.domain.scrapers.PeachscoreHTMLScraper
import com.example.webscraperapi.domain.scrapers.SlackHTMLScraper

class ScraperPipelineFactory {
    fun createPipeline(path: String): ScraperPipeline =
        when (path) {
            "https://peachscore.com/" -> ScraperPipeline(HTTPFetcher(), PeachscoreHTMLScraper())
            "https://slack.com/" -> ScraperPipeline(HTTPFetcher(), SlackHTMLScraper())
            else -> throw RelevantScraperNotFoundException()
        }
}