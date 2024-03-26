package org.example.org.example

class SearchController {
    private var query: String = ""

    companion object {
        private const val MAX_RESULTS = 20
        fun create(initialQuery: String) : SearchController {
            val controller = SearchController()
            controller.query = initialQuery
            return controller
        }
    }
}
