package com.slashGil.basicintegration

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory

const val DEFAULT_PATH = "/"
const val APPLICATION_JSON = "application/json"

private fun getJson() = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
}

fun getKotlinConverterFactory() = getJson().asConverterFactory(APPLICATION_JSON.toMediaType())