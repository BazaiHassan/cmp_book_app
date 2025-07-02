package com.hbazai.bookpedia.book.data.network

import com.hbazai.bookpedia.book.domain.Book
import com.hbazai.bookpedia.core.data.safeCall
import com.hbazai.bookpedia.core.domain.DataError
import com.hbazai.bookpedia.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org"

class KtorRemoteBookDataSource(
    private val httpClient: HttpClient
) {

    suspend fun searchBook(
        query: String,
        resultLimit: Int? = null
    ): Result<List<Book>, DataError.Remote> {
        return safeCall {
            httpClient.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter(
                    "fields",
                    "key,title,language,cover_i,author_key,author_name,cover_edition_key,first_publish_year,ratings_average,ratings_count,number_of_pages_median,edition_count"
                )
            }
        }
    }

}