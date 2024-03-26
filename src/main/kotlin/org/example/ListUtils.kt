package org.example

fun printListUtils() {
    println(ListUtils.nonEmptyList(*arrayOf(1, 2, 3)))
    println(arrayOf(1, 2, 3).nonEmptyList())
    println(ListUtils.setToNonEmptyList(setOf(4, 5, 6)))
    println(setOf(4, 5, 6).toNonEmptyList())
}
fun <T> Array<T>.nonEmptyList() : List<T> {
    check(isNotEmpty()) {
        "NonEmptyList must have at least 1 item"
    }
    return toList()
}
fun <T> Set<T>.toNonEmptyList() : List<T> {
    check(isNotEmpty()) {
        "NonEmptyList must have at least 1 item"
    }
    return toList()
}

class ListUtils {
    companion object {
        fun <T> nonEmptyList(vararg items: T): List<T> {
            check(items.isNotEmpty()) {
                "NonEmptyList must have at least 1 item"
            }
            return items.toList()
        }

        fun <T> setToNonEmptyList(set: Set<T>): List<T> {
            check(set.isNotEmpty()) {
                "NonEmptyList must have at least 1 item"
            }
            return set.toList()
        }
    }
}
