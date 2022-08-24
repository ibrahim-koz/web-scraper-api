package com.example.webscraperapi.domain.factory

import com.example.webscraperapi.domain.context.ScraperPipeline
import com.example.webscraperapi.domain.exceptions.RelevantScraperNotFoundException
import com.example.webscraperapi.domain.readers.BrowserFetcher
import com.example.webscraperapi.domain.readers.HTTPFetcher
import com.example.webscraperapi.domain.sanitizers.NonAlphanumericCharacterSanitizer
import com.example.webscraperapi.domain.scrapers.*

class ScraperPipelineFactory {
    fun createPipeline(path: String): ScraperPipeline =
        when (path) {
            "https://peachscore.com/" -> ScraperPipeline(
                HTTPFetcher(),
                PeachscoreHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://slack.com/" -> ScraperPipeline(
                HTTPFetcher(),
                SlackHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://along.technology/" -> ScraperPipeline(
                BrowserFetcher(),
                AlongTechnologyHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://eatchefly.com/" -> ScraperPipeline(
                BrowserFetcher(),
                EatCheflyHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://optichronix.com/" -> ScraperPipeline(
                HTTPFetcher(),
                OptiChroniXHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://risekit.co/" -> ScraperPipeline(
                HTTPFetcher(),
                RiseKitHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://buildly.io/" -> ScraperPipeline(
                BrowserFetcher(),
                BuildlyIoHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            "https://ibrainy.org/" -> ScraperPipeline(
                BrowserFetcher(),
                IBrainyOrgHTMLScraper(NonAlphanumericCharacterSanitizer())
            )

            else -> throw RelevantScraperNotFoundException()
        }
}