package com.example.webscraperapi.domain.context

import com.example.webscraperapi.domain.readers.IReader
import com.example.webscraperapi.domain.scrapers.IScraper

class ScraperPipeline(private var reader: IReader, private var scraper: IScraper) {
    fun start(path: String) = scraper.scrape(reader.read(path))
}