package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// isActive 확장 함수로 체크 시 exception 발생 안함
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        /* try{*/
        var nextPrintTime = startTime
        var i=0
        println("ïsActive ${isActive}")
        while (isActive){
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        println("ïsActive ${isActive}")
        /*}catch (e: Exception){
            println("${e}");
        }*/

    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

}
