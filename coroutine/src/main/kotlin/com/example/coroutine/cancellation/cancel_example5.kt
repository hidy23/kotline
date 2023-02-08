package com.example.coroutine

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// 코루틴이 취소된 후에도 finally 구간에서 또다시 코루틴을 실행할 수 있다.
fun main() = runBlocking {

    val job = launch {
        try{
            repeat(1000){ i->
                println("job: I'm sleeping ${i} ...")
                delay(500L)
            }

        }finally {
            withContext(NonCancellable){
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit")
}
