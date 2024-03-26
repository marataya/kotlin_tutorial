package org.example

private val hoursInMillis = 60 * 60 * 1000
//internal fun millisForHours(hours:Int) = hours * hoursInMillis

fun Int.millisForHours() = this * hoursInMillis
