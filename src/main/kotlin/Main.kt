package org.example



fun main() {
//    runClassDesign()
    runFuntionTypesAndLambdas()

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
