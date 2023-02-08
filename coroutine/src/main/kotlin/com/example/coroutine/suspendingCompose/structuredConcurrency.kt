package com.example.coroutine.suspendingCompose

import kotlin.Exception
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 사용하지 말아야할 예제
// structured concurrency 를 사용해라.
fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in ${time} ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUseFul_1_() }
    val two = async { doSomethingUseFul_2_() }
    one.await() + two.await()
}

suspend fun doSomethingUseFul_1_(): Int {
    delay(3000L)
    return 13
}

suspend fun doSomethingUseFul_2_(): Int {
    delay(3000L)
    return 29
}


