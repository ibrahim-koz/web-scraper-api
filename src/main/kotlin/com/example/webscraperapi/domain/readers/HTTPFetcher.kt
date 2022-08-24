package com.example.webscraperapi.domain.readers

import it.skrape.core.htmlDocument
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.Request

class HTTPFetcher : IReader {
    override fun read(path: String): String = HttpFetcher.fetch(Request(url = path)).htmlDocument { this }.toString()
}