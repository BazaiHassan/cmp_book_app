package com.hbazai.bookpedia.book.data.network

import com.hbazai.bookpedia.book.data.dto.SearchResponseDto
import com.hbazai.bookpedia.core.domain.DataError
import com.hbazai.bookpedia.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>
}