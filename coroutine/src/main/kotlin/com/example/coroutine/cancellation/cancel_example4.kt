package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

// 코루틴 자원 해제
fun main() = runBlocking {
    val job = launch(Dispatchers.Default) {
        try{
            repeat (1000){ i->
                println("job: I'm sleeping ${i} ...")
                delay(500L)
            }
        }finally {
            println("Job: I'm running finally")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

}
