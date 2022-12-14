package com.example.webscraperapi.incoming_ports

import com.example.webscraperapi.domain.exceptions.RelevantScraperNotFoundException
import com.example.webscraperapi.domain.use_cases.scrape
import com.example.webscraperapi.requests.ScrapeRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/scrape")
class ScrapePort {
    @ExceptionHandler(RelevantScraperNotFoundException::class)
    fun handleBadRequest(): ResponseEntity<String> =
        ResponseEntity("A scraper relevant to this domain name is absent.", HttpStatus.BAD_REQUEST)

    @GetMapping
    fun get() = listOf(
        "https://peachscore.com/",
        "https://slack.com/",
        "https://along.technology/",
        "https://eatchefly.com/",
        "https://optichronix.com/",
        "https://risekit.co/",
        "https://buildly.io/",
        "https://ibrainy.org/"
    )

    @PostMapping
    fun post(@RequestBody scrapeRequest: ScrapeRequest) = scrape(scrapeRequest.path)
}