package org.example

import kotlin.properties.Delegates

class ViewModel {

    var currentQuery: String by Delegates.observable("") {property, oldVal, newVal ->
        println("$oldVal -> $newVal")
    }

    val logger: Logger by lazy {
        println("initializing the logger")
        ApplicationLogger(SimpleLogger())
    }

    fun search(query: String) {
        logger.log(tag = "query", query)
        currentQuery = query
    }
}

