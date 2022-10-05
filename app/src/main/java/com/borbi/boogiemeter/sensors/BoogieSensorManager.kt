package com.borbi.boogiemeter.sensors

import android.app.Application
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager

class BoogieSensorManager(application: Application) {

    var sensorManager: SensorManager
    var sensorGyroscope: Sensor? = null
    var sensorAccelerometer: Sensor? = null

    init {
        sensorManager = application.getSystemService(Context.SENSOR_SERVICE) as SensorManager

//        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }
}