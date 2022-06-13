package com.example.coroutinesexample

import kotlinx.coroutines.*

class MultiThreading {


}

fun main() {
    uiTask()

    //code  execute in parallelly.(parallel Thread)
    GlobalScope.launch {
        networkCallTask()
    }

    uiTask()
    Thread.sleep(3000L)

}


suspend fun networkCallTask() {
    delay(2000L)
    withContext(Dispatchers.IO) {
        println("Loading......")
        println("Thread : ${Thread.currentThread().name}")

    }


}

fun uiTask() {
    println("Refresh UI......")
    println("Thread : ${Thread.currentThread().name}")
}