package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class RiseKitHTMLScraper : IScraper {
    override fun scrape(data: String) = htmlDocument(data) {
        CompanyInfo(
            name = title {
                findFirst {
                    text
                }
            }.split(" ").first(),

            description =
            meta {
                withAttribute = "name" to "description"
                findAll {
                    attribute("content")
                }
            } + meta {
                withAttribute = "property" to "og:description"
                findAll {
                    attribute("content")
                }
            } + h1 {
                withClass = "home-hero-header" and "centered"
                findAll {
                    eachText
                }
            } + span {
                withClass = "emphasized-home-hero-text"
                findAll {
                    eachText
                }
            } + p {
                withClass = "hero-paragraph"
                findAll {
                    eachText
                }
            } + div {
                withClass = "service-explainer-text-container"
                p {
                    strong {
                        findAll {
                            eachText
                        }
                    }
                }
            }
        )
    }
}
