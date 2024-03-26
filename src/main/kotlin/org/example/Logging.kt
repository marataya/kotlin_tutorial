package org.example

val Int.isEven: Boolean
    get() = this.mod(2) == 0


//fun <T> T.log() = println(this)

interface Logger {
    fun log(tag: String, any: Any)
}

class SimpleLogger : Logger {
    override fun log(tag: String, any: Any) {
        println("$tag: ${any.toString()}")
    }
}

class ApplicationLogger(private val delegate: Logger) : Logger by delegate

fun exampleLoggin() {
    println(2.millisForHours())

    println(3.isEven)
    println(4.isEven)

//    5.log()
//    "abc".log()
//    listOf(1, 2, 3).log()

//    val appLogger = ApplicationLogger(SimpleLogger())
//    appLogger.log("example", any=appLogger)

    val viewModel = ViewModel()
//    viewModel.search()
}
