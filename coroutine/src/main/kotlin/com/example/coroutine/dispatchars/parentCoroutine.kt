package com.example.coroutine.dispatchars

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 기본적으로 부모 코루틴은 자식코루틴이 종료될때 까지 기다린다.

fun main() = runBlocking<Unit> {
    val request = launch {
        repeat(3) {i->
            launch {
                delay((i+1)*200L)
                println("Coroutine ${i} is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    println("Now processing of the request is complete")
}
