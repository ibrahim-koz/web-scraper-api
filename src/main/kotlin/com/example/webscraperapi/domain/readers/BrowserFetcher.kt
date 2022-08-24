package com.example.webscraperapi.domain.readers

import it.skrape.core.htmlDocument
import it.skrape.fetcher.BrowserFetcher
import it.skrape.fetcher.Request

class BrowserFetcher : IReader {
    override fun read(path: String): String = BrowserFetcher.fetch(Request(url = path)).htmlDocument { this }.toString()
}