package org.android

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}

private fun runFoldedPhone() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.unfold()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}

private fun runInternetProfile() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

private fun runTempConversion() {
    printFinalTemperature(initialMeasurement = 27.0, "Celsius", finalUnit = "Fahrenheit") {
        (9.0 / 5) * it + 32
    }
    printFinalTemperature(initialMeasurement = 350.0, "Kelvin", finalUnit = "Celsius") {
        it - 273.15
    }
    printFinalTemperature(initialMeasurement = 10.0, "Fahrenheit", finalUnit = "Kelvin") {
        (5.0 / 9) * (it - 32) + 273.15
    }
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when {
        age in 0..12 -> 15
        age in 13..60 && isMonday -> 25
        age in 13..60 -> 30
        age in 61..100 -> 20
        else -> -1
    }
}

private fun runFuntionTypesAndLambdas() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    repeat(3) { trickFunction() }
    treatFunction()
}

private fun runClassDesign() {
    val smartDevice1 = SmartTvDevice("Android TV", "Entertainment")
    val smartDevice2 = SmartLightDevice("Google Light", "Utility")
    smartDevice1.printDeviceInfo()
    smartDevice2.printDeviceInfo()
    val smartHome: SmartHome = SmartHome(smartDevice1, smartDevice2)
    smartHome.turnOnAllDevices()
    smartDevice2.decreaseBrightness()
    smartDevice2.decreaseBrightness()
    smartDevice2.decreaseBrightness()
    smartDevice2.decreaseBrightness()
    println(smartDevice2.brightnessLevel)
}
