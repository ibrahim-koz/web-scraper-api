package com.example.webscraperapi.domain.readers

interface IReader {
    fun read(path: String): String
}