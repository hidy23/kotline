package com.example.coroutine.dispatchars

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    launch {
        println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("unconfined : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("default : I'm working in thread ${Thread.currentThread().name}")
    }

    newSingleThreadContext("MyOwnThread").use{
        launch(it) {
            println("newSingleThreadContext : I'm working in thread ${Thread.currentThread().name}")
        }
    }

}
