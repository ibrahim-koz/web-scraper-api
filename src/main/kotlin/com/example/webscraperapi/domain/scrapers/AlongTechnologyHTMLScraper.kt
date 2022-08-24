package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import com.example.webscraperapi.domain.sanitizers.ISanitizer
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class AlongTechnologyHTMLScraper(override val sanitizer: ISanitizer) : IScraper {
    override fun scrape(data: String) = htmlDocument(data) {
        CompanyInfo(
            name = meta {
                withAttribute = "property" to "og:title"
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
            } + span {
                withClass = "heading__highlight" and "italic" and "animated"
                findAll {
                    eachText
                }
            } + div {
                withClass = "stack__content" and "sticky"
                h2 {
                    withClass = "heading"
                    findAll {
                        eachText
                    }
                }
            } + p {
                withClass = "hero__paragraph"
                findAll {
                    eachText
                }
            } + span {
                withClass = "heading__highlight" and "orange" and "italic" and "animated"
                findFirst {
                    text
                }
            }
        )
    }

}
