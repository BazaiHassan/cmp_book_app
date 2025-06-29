package com.hbazai.bookpedia.book.presentation.book_list

import com.hbazai.bookpedia.book.domain.Book
import com.hbazai.bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText?=null,
)
