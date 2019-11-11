package com.borbi.boogiemeter.recording

import android.app.Application
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.borbi.boogiemeter.sensors.BoogieSensorManager

class RecordingViewModel(application: Application)  : AndroidViewModel(application) {

    private lateinit var boogieSensorManager: BoogieSensorManager

    init {
        boogieSensorManager = BoogieSensorManager(application)
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RecordingViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RecordingViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}