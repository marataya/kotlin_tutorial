package org.example

import kotlin.random.Random

fun getString(): StringResult {
    return try {
        StringResult.Success(getRandomString())
    } catch (error: IllegalStateException) {
        StringResult.Error(error)
    }
}

fun getRandomString(): String {
    val rand = Random.nextInt(10)
    return if (rand > 5) {
        throw IllegalStateException()
    } else {
        rand.toString()
    }
}
sealed class StringResult {
    data class Success(val value: String) : StringResult()
    data class Error(val error: Throwable) : StringResult()

}
