package com.example.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

// withTimeout 람수를 이용한 중단. exception 이 떨어지며 종료됨.
// --->  다움 예제에서 해결.  withTimeoutOrNull
fun main() = runBlocking {
    withTimeout(1300L){
        repeat(1000){i->
            println("I'm sleeping ${i} ...")
            delay(500L)
        }
    }
}
