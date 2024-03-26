package org.example

class Student(
    age:Int,
    firstName: String,
    lastName: String
) : APerson(age, firstName, lastName) {
    override fun printName() {
        println("Student: $firstName $lastName")
    }
}
