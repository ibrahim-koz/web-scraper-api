package com.example.webscraperapi.domain.factory

import com.example.webscraperapi.domain.context.ScraperPipeline
import com.example.webscraperapi.domain.exceptions.RelevantScraperNotFoundException
import com.example.webscraperapi.domain.readers.BrowserFetcher
import com.example.webscraperapi.domain.readers.HTTPFetcher
import com.example.webscraperapi.domain.scrapers.AlongTechnologyHTMLScraper
import com.example.webscraperapi.domain.scrapers.PeachscoreHTMLScraper
import com.example.webscraperapi.domain.scrapers.SlackHTMLScraper

class ScraperPipelineFactory {
    fun createPipeline(path: String): ScraperPipeline =
        when (path) {
            "https://peachscore.com/" -> ScraperPipeline(HTTPFetcher(), PeachscoreHTMLScraper())
            "https://slack.com/" -> ScraperPipeline(HTTPFetcher(), SlackHTMLScraper())
            "https://along.technology/" -> ScraperPipeline(BrowserFetcher(), AlongTechnologyHTMLScraper())
//            "https://eatchefly.com/" -> ScraperPipeline(HTTPFetcher(), EatCheflyHTMLScraper())
//            "https://optichronix.com/" -> ScraperPipeline(HTTPFetcher(), OptiChronixHTMLScraper())
//            "https://risekit.co/" -> ScraperPipeline(HTTPFetcher(), RiseKitHTMLScraper())
//            "https://buildly.io/" -> ScraperPipeline(HTTPFetcher(), BuildlyIoHTMLScraper())
//            "https://tryeazy.co/" -> ScraperPipeline(HTTPFetcher(), TryEazyHTMLScraper())
//            "https://librainy.org/" -> ScraperPipeline(HTTPFetcher(), LibrayinyOrgHTMLScraper())
            else -> throw RelevantScraperNotFoundException()
        }
}