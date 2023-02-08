package com.example.coroutine.suspendingCompose

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 무거운 동작을 하는 경우 예제로... 순차적으로 실행됨.
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomeThingUsefulTwo()
        println("The answer is ${one+two}")
    }
    println("completed in ${time} ms")
}

suspend fun doSomethingUsefulOne(): Int {
    println("dosomethingUseful One")
    delay(1000L)
    return 13

}

suspend fun doSomeThingUsefulTwo(): Int {
    println("dosomethingUseful Two")
    delay(1000L)
    return 29
}
