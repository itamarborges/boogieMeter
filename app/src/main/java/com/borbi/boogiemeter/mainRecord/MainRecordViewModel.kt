package com.borbi.boogiemeter.mainRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainRecordViewModel : ViewModel() {

    private val _navigateToEvent = MutableLiveData<Boolean?>()

    val navigateToEvent: LiveData<Boolean?>
        get() = _navigateToEvent

    fun moveToEvent() {
        _navigateToEvent.value = true
    }

    fun doneMoveToEvent() {
        _navigateToEvent.value = false
    }

}