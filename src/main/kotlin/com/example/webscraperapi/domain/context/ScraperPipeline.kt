package com.example.webscraperapi.domain.context

import com.example.webscraperapi.domain.readers.IReader
import com.example.webscraperapi.domain.scrapers.IScraper

class ScraperPipeline(private val reader: IReader, private val scraper: IScraper) {
    fun start(path: String) =
        scraper.scrape(reader.read(path))
}
