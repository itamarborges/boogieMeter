package com.borbi.boogiemeter.sensors

import android.app.Application
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService

class BoogieSensorManager(application: Application) {

    private lateinit var sensorManager: SensorManager

    init {
        sensorManager = application.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)

        Log.d("teste", deviceSensors.toString())
    }

}