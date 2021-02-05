package com.borbi.boogiemeter.mainRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainRecordViewModel : ViewModel() {

    private val _navigateToEvent = MutableLiveData<Boolean?>()
    private val _navigateToRecording = MutableLiveData<Boolean?>()

    val navigateToEvent: LiveData<Boolean?>
        get() = _navigateToEvent

    val navigateToRecording: LiveData<Boolean?>
        get() = _navigateToRecording

    fun moveToEvent() {
        _navigateToEvent.value = true
    }

    fun doneMoveToEvent() {
        _navigateToEvent.value = false
    }

    fun moveToRecording() {
        _navigateToRecording.value = true
    }

    fun doneMoveToRecording() {
        _navigateToRecording.value = false
    }
    
}