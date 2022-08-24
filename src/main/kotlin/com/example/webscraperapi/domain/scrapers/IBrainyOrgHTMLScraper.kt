package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class IBrainyOrgHTMLScraper : IScraper {
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
                withClass = "tw-text-ct-iq-tests-dark" and "tw-font-semibold" and "tw-px-3"
                findAll {
                    eachText
                }
            } + div {
                withClass = "tw-font-bold" and "tw-text-white" and "tw-px-3"
                findAll {
                    eachText
                }
            } + div {
                withClass = "tw-text-xl" and "tw-py-3"
                findAll {
                    eachText
                }
            } + div {
                withClass = "tw-py-3"
                section {
                    findAll {
                        eachText
                    }
                }
            }
        )
    }
}
