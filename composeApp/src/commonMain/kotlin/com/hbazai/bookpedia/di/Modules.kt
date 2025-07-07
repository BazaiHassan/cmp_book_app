package com.hbazai.bookpedia.di


import com.hbazai.bookpedia.book.data.network.KtorRemoteBookDataSource
import com.hbazai.bookpedia.book.data.network.RemoteBookDataSource
import com.hbazai.bookpedia.book.data.repository.DefaultBookRepository
import com.hbazai.bookpedia.book.domain.BookRepository
import com.hbazai.bookpedia.book.presentation.SelectedBookViewModel
import com.hbazai.bookpedia.book.presentation.book_list.BookListViewModel
import com.hbazai.bookpedia.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule:Module

val sharedModule = module {
    single {
        HttpClientFactory.create(get())
    }

    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
}