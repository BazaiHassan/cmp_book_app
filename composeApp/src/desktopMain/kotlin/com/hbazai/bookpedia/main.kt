package com.hbazai.bookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hbazai.bookpedia.app.App
import com.hbazai.bookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CMP-Bookpedia",
        ) {
            App()
        }
    }
}