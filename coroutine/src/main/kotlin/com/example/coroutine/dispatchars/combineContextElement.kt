package com.example.coroutine.dispatchars

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("Test")) {
        println(" I'm working in thread ${Thread.currentThread().name}")
    }
}
