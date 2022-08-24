package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class OptiChroniXHTMLScraper : IScraper {
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
            } + div {
                withAttribute = "data-ux" to "HeroText"
                p {
                    span {
                        findAll {
                            eachText
                        }
                    }
                }
            } + h4 {
                withAttribute = "role" to "heading"
                withAttribute = "data-ux" to "ContentHeading"
                findAll {
                    eachText
                }
            } + div {
                withAttribute = "data-ux" to "ContentText"
                p {
                    span {
                        findAll {
                            eachText
                        }
                    }
                }
            }
        )
    }

}
