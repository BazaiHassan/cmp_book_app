package com.hbazai.bookpedia.book.data.repository


import com.hbazai.bookpedia.book.data.mappers.toBook
import com.hbazai.bookpedia.book.data.network.RemoteBookDataSource
import com.hbazai.bookpedia.book.domain.Book
import com.hbazai.bookpedia.book.domain.BookRepository
import com.hbazai.bookpedia.core.domain.DataError
import com.hbazai.bookpedia.core.domain.Result
import com.hbazai.bookpedia.core.domain.map

class DefaultBookRepository(private val remoteBookDataSource: RemoteBookDataSource) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map {
                    it.toBook()
                }
            }
    }
}