package com.example.coroutine.dispatchars

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// GlobalScope는 프로그램 종료 시에만 종료. 어느 구간에 작성하든 부모가 없다.
fun main() = runBlocking<Unit> {

    val request = launch {
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }

        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("main: Who has surviced request cancellation?")

}
