package com.hbazai.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.hbazai.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(configure={ initKoin() }) { App() }