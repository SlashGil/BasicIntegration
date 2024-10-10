package com.slashGil.basicintegration

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import retrofit2.Retrofit

open class MockWebServerRule : TestRule {

    private val server = MockWebServer()

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                server.start()
                base.evaluate()
                server.shutdown()
            }
        }
    }

    fun mockRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(server.url(DEFAULT_PATH))
            .addConverterFactory(getKotlinConverterFactory())
            .build()


    fun givenMockResponse(responseCode: Int = 200, fileName: String? = null) {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(responseCode)
        fileName.addBodyTo(mockResponse)
        server.enqueue(mockResponse)
    }

    private fun String?.addBodyTo(mockResponse: MockResponse) = this?.run {
        val fileResponse = readFile(this)
        mockResponse.setBody(fileResponse)
    }

    private fun readFile(name: String) = this::class.java.classLoader?.getResource(name)?.readText().orEmpty()
}
