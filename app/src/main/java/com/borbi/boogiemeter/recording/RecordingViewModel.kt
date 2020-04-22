package com.borbi.boogiemeter.recording

import android.app.Application
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.*
import com.borbi.boogiemeter.sensors.BoogieSensorManager
import kotlin.math.abs

class RecordingViewModel(application: Application)  : AndroidViewModel(application), SensorEventListener {

    private var boogieSensorManager: BoogieSensorManager
    private var _accelerometerContent: ObservableField<String> = ObservableField("")
    private var _jumps: ObservableInt = ObservableInt(0)
    private var startJumpUp = false
    private var endJumpUp = false
    private var startJumpDown = false
    private var endJumpDown = false
    private var _sumContent: ObservableField<String> = ObservableField("")

    private val _navigateToMainRecord = MutableLiveData<Boolean?>()

    val navigateToMainRecord: LiveData<Boolean?>
        get() = _navigateToMainRecord

    fun moveToMainRecord() {
        _navigateToMainRecord.value = true
    }

    fun doneMoveToMainRecord() {
        _navigateToMainRecord.value = false
    }

     val accelerometerContent : ObservableField<String>
        get() = _accelerometerContent

    val jumpsContent : ObservableInt
        get() = _jumps

    val sumContent : ObservableField<String>
        get() = _sumContent

    init {
        boogieSensorManager = BoogieSensorManager(application)
        boogieSensorManager.also {

            it.sensorAccelerometer?.also { service ->
                it.sensorManager.registerListener(this, service, SensorManager.SENSOR_DELAY_NORMAL)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        boogieSensorManager.sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, p1: Int) {


    }

    override fun onSensorChanged(event: SensorEvent?) {

        if (event?.sensor == boogieSensorManager.sensorAccelerometer) {
            _accelerometerContent.set("X: "+event?.values?.get(0).toString() +
                    " Y:" +event?.values?.get(1).toString() +
                    " Z:" +event?.values?.get(2).toString())


            _sumContent.set((abs(event?.values?.get(0)!!) +abs(event.values?.get(1)!!) + abs(event.values?.get(2)!!)).toString());


            if (abs(event.values?.get(1)!!) > 11 && !startJumpUp) {
                startJumpUp = true
                Log.d("zzz0", event.values?.get(1).toString());
                return;
            }

            if (abs(event.values?.get(1)!!) < 8 && startJumpUp && !endJumpUp) {
                endJumpUp = true
                Log.d("zzz1", event.values?.get(1).toString());
                return;
            }

            if (abs(event.values?.get(1)!!) > 11 && startJumpUp && endJumpUp && !startJumpDown) {
                startJumpDown = true
                Log.d("zzz2", event.values?.get(1).toString());
                return;
            }

            if (abs(event.values?.get(1)!!) < 8 && startJumpUp && endJumpUp && startJumpDown && !endJumpDown) {
                endJumpDown = true
                Log.d("zzz3", event.values?.get(1).toString());
            }

            if (startJumpUp && endJumpUp && startJumpDown && endJumpDown) {
                Log.d("jump", event.timestamp.toString());
                _jumps.set(_jumps.get()+1)
                startJumpUp = false
                endJumpUp = false
                startJumpDown = false
                endJumpDown = false
            }
        }
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