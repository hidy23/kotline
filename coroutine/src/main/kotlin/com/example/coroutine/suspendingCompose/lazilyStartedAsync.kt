package com.example.coroutine.suspendingCompose

import kotlin.system.measureTimeMillis
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// lazy를 이용하여 늦게 시작. start()를 하지 않을 경우 await() 라인에서 start 됨.
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUseful1() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUseful2() }
        one.start()
        two.start()
        println("The answer is ${one.await()+two.await()}")
    }
    println("completed in ${time} ms")
}

suspend fun doSomethingUseful1(): Int {
    println("dosomethingUseful One")
    delay(1000L)
    return 13

}

suspend fun doSomethingUseful2(): Int {
    println("dosomethingUseful Two")
    delay(1000L)
    return 29
}
