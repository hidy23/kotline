package com.example.coroutine.dispatchars

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Activity {
    private val mainScope = CoroutineScope(Dispatchers.Default)

    fun destroy(){
        mainScope.cancel()
    }

    fun doSomething(){
        repeat(10){ i->
            mainScope.launch {
                delay((i+1)*200L)
                println("Coroutines ${i} is done")
            }
        }
    }
}

fun main() = runBlocking<Unit> {
    val activity = Activity()
    activity.doSomething()
    println("Launched coroutines")
    delay(500L)
    println("Destroying activity!")
    activity.destroy()
    delay(1000)
}
