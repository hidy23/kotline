package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

// 코루틴 안에 suspend 함수가 있어야 job.cancel 이 작동됨
// job.cancel 은 resume 시 exception 을 발생시켜 쥐소하는 로직임.
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
       /* try{*/
            var nextPrintTime = startTime
            var i=0
            while (i<5){
                if (System.currentTimeMillis() >= nextPrintTime) {
                    // delay(1L)
                    yield()
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        /*}catch (e: Exception){
            println("${e}");
        }*/

    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

}
