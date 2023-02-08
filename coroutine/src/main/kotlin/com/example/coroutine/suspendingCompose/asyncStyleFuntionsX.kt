package com.example.coroutine.suspendingCompose

import kotlin.Exception
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 사용하지 말아야할 예제
// structured concurrency 를 사용해라.
fun main(){
    try {
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync()
            val two = somethingUsefulTwoAsync()

            println("my exceptions")
            throw Exception("my exceptions")

            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }
        println("completed in ${time} ms")
    }catch (e: Exception){


    }

    runBlocking {
        delay(100000)
    }

}

fun somethingUsefulOneAsync() = GlobalScope.async {
    println("start, somethingUsefulOneAsync")
    val res = doSomethingUseFul_1()
    println("end, somethingUsefulOneAsync")
    res
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
    println("start, somethingUsefulTwoAsync")
    val res = doSomethingUseFul_2()
    println("end, somethingUsefulTwoAsync")
    res
}


suspend fun doSomethingUseFul_1(): Int {
    delay(3000L)
    return 13
}

suspend fun doSomethingUseFul_2(): Int {
    delay(3000L)
    return 29
}


