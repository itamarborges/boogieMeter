package com.borbi.boogiemeter.mainRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainRecordViewModel : ViewModel() {

    private val _navigateToRecording = MutableLiveData<Boolean?>()

    val navigateToRecording: LiveData<Boolean?>
        get() = _navigateToRecording

    fun moveToRecording() {
        _navigateToRecording.value = true
    }

    fun doneMoveToRecording() {
        _navigateToRecording.value = false
    }


}