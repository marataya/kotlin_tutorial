package org.android

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "offline"
        set(value) {
            if (value == "on" && field == "off") {
                field = value
            }
            if (value == "off" && field == "on") {
                field = value
            }
        }
    open val deviceType = "undefined"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown code"
        }
    }

    open fun turnOn() {
        deviceStatus = "On"
    }

    open fun turnOff() {
        deviceStatus = "Off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    private var speakerVolume by RangeRegulator(initialVal = 2, minVal = 0, maxVal = 100)
    private var channelNumber by RangeRegulator(initialVal = 1, minVal = 0, maxVal = 200)

    internal fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel switched to $channelNumber")
    }

    internal fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }

    fun prevChannel() {
        channelNumber--
        println("Channel switched to $channelNumber")
    }

    override val deviceType: String = "Smart TV"

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }


}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType: String = "Smart Light"

    var brightnessLevel by RangeRegulator(initialVal = 0, minVal = 0, maxVal = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")

    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun turnOnLightDevice() {
        smartLightDevice.turnOn()
    }

    fun turnOffLightDevice() {
        smartLightDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun changeTvChannelToPrev() {
        smartTvDevice.prevChannel()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }

    fun turnOnAllDevices() {
        smartTvDevice.turnOn()
        smartLightDevice.turnOn()
    }

    fun turnOffAllDevices() {
        smartTvDevice.turnOff()
        smartLightDevice.turnOff()
    }
}

class RangeRegulator(initialVal: Int, private val minVal: Int, private val maxVal: Int) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialVal
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minVal..maxVal) {
            fieldData = value
        }
    }
}
