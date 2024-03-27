package org.example

import kotlinx.coroutines.*

private suspend fun refreshTasks() {
    delay(3000)
    println("Refreshing tasks on ${Thread.currentThread().name}")
}

private suspend fun refreshReservations() {
    delay(3000)
    println("Refreshing reservations on ${Thread.currentThread().name}")
}

private fun refreshUser() {
    println("Refreshing user on ${Thread.currentThread().name}")
}

private fun updateUI() {
    println("Updating UI on ${Thread.currentThread().name}")
}

private fun cancelEverything(vararg jobs: Job) {
    jobs.forEach { it.cancel() }
}


private suspend fun loadItemsFromDB(): List<String> {
    delay(5000)
    return listOf("kotlin", "java", "c#")
}
private suspend fun loadItemsFromNetwork(): List<String> {
    delay(5000)
    return listOf("rust", "python", "c")
}

fun runTaskAsync(): Unit = runBlocking {
    val tasks = async { refreshTasks() }
    val reservations = async { refreshReservations() }

    awaitAll(tasks, reservations)


    withContext(this@runBlocking.coroutineContext) {
        updateUI()
    }

    val job = launch { refreshUser() }

    job.cancel()
}
fun main(): Unit = runBlocking {
    val db = async { loadItemsFromDB() }
    val network = async { loadItemsFromNetwork() }

    val results = db.await() + network.await()

    println(results)
}
