package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class BuildlyIoHTMLScraper : IScraper {
    override fun scrape(data: String) = htmlDocument(data) {
        CompanyInfo(
            name = title {
                findFirst {
                    text
                }
            }.split(" ").last(),

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
            } + h2 {
                withClass = "elementor-heading-title" and "elementor-size-large"
                findAll {
                    eachText
                }
            } + h5 {
                withAttribute = "data-elementor-setting-key" to "title"
                findAll {
                    eachText
                }
            } + h4 {
                withClass = "elementor-heading-title" and "elementor-size-medium"
                findAll {
                    eachText
                }
            } + div {
                withClass = "elementor-text-editor" and "elementor-clearfix"
                p {
                    findAll {
                        eachText
                    }
                    span {
                        findAll {
                            eachText
                        }
                    }
                }
            } + h3 {
                withClass = "elementor-heading-title" and "elementor-size-large"
                findAll {
                    eachText
                }
            } + h3 {
                withClass = "elementor-price-table__heading"
                findAll {
                    eachText
                }
            } + div {
                withClass = "elementor-price-table__feature-inner"
                span {
                    findAll {
                        eachText
                    }
                }
            }
        )
    }
}
