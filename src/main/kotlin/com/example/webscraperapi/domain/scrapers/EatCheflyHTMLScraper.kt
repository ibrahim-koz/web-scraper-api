package com.example.webscraperapi.domain.scrapers

import com.example.webscraperapi.domain.dto.CompanyInfo
import com.example.webscraperapi.domain.sanitizers.ISanitizer
import it.skrape.core.htmlDocument
import it.skrape.selects.and
import it.skrape.selects.attribute
import it.skrape.selects.eachText
import it.skrape.selects.html5.*

class EatCheflyHTMLScraper(override val sanitizer: ISanitizer) : IScraper {
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
            } + h1 {
                withClass = "TypographyElements__H1-sc-1st53ft-0" and "style__Title-sc-15fl6oq-9" and "iHBwiq"
                findAll {
                    eachText
                }
            } + div {
                withClass = "TypographyElements__AnimatedText-sc-1st53ft-6" and "yUxnb"
                findAll {
                    eachText
                }
            } + div {
                withClass = "TypographyElements__UnderlinedText-sc-1st53ft-8" and "dKKDt"
                findAll {
                    eachText
                }
            } + a {
                withClass = "ButtonLink-sc-1gv9h1y-0" and "jXdVeq"
                findAll {
                    eachText
                }
            } + p {
                withClass = "TypographyElements__Text-sc-1st53ft-4" and "iZFujR"
                findAll {
                    eachText
                }
            } + h2 {
                withClass = "TypographyElements__H2-sc-1st53ft-1" and "style__CardText-sc-1gn73ww-4" and "ewyjNY"
                findAll {
                    eachText
                }
            } + h2 {
                withClass = "TypographyElements__H2-sc-1st53ft-1" and "style__Title-wgtzmd-7" and "hMoCc"
                findAll {
                    eachText
                }
            } + p {
                withClass = "TypographyElements__Text-sc-1st53ft-4" and "style__SignText-wgtzmd-3" and "fIIOBI"
                findAll {
                    eachText
                }
            }
        )
    }
}
