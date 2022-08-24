package com.example.webscraperapi.incoming_ports

import com.example.webscraperapi.domain.use_cases.scrape
import com.example.webscraperapi.requests.ScrapeRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/scrape")
class ScrapePort {
    @GetMapping
    fun get() = listOf("https://peachscore.com/", "https://slack.com/")
    @PostMapping
    fun post(@RequestBody scrapeRequest: ScrapeRequest) = scrape(scrapeRequest.path)
}