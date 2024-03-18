package org.example

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        val refererInfo = if (referrer != null) {
            "Has a referrer named ${referrer.name}, who likes ${referrer.hobby}"
        } else {
            "Doesnt have a referrer"
        }
        println("Likes to $hobby. $refererInfo \n\n")
    }
}
