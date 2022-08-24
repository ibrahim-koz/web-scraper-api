package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import com.example.webscraperapi.domain.sanitizers.ISanitizer
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class PeachscoreHTMLScraper(override val sanitizer: ISanitizer): IScraper {
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
                withClass = "title"
                findAll {
                    eachText
                }
            } + div {
                withClass = "column_attr" and "mfn-inline-editor" and "clearfix"
                findFirst {
                    text
                }
            } + h4 {
                withClass = "title"
                findAll {
                    eachText
                }
            } + div {
                p {
                    findAll {
                        eachText
                    }
                }
            }
        )
    }

}