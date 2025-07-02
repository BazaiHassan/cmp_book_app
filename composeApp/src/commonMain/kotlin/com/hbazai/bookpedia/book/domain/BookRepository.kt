package com.hbazai.bookpedia.book.domain

import com.hbazai.bookpedia.core.domain.DataError
import com.hbazai.bookpedia.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query:String):Result<List<Book>, DataError.Remote>
}