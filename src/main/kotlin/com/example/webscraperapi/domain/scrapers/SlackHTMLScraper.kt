package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.h2
import it.skrape.selects.html5.meta
import it.skrape.selects.html5.p

class SlackHTMLScraper: IScraper {
    override fun scrape(data: String) = htmlDocument(data) {
        CompanyInfo(
            name = meta {
                withAttribute = "property" to "og:site_name"
                findFirst {
                    attribute("content")
                }
            },

            description =
            meta {
                withAttribute = "name" to "description"
                findAll {
                    attribute("content")
                }
            } + h2 {
                withClass = "display-as-h1" and "u-margin-top--flush"
                findAll {
                    eachText
                }
            } + p {
                withClass = "o-section--feature__copy" and "u-margin-bottom--medium"
                findAll {
                    eachText
                }
            }
        )
    }
}