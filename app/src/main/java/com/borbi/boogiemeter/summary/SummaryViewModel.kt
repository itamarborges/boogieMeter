package com.borbi.boogiemeter.summary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SummaryViewModel : ViewModel() {

    private val _navigateToMainRecord = MutableLiveData<Boolean?>()

    val navigateToMainRecord: LiveData<Boolean?>
        get() = _navigateToMainRecord

    fun moveToMainRecord() {
        _navigateToMainRecord.value = true
    }

    fun doneMoveToMainRecord() {
        _navigateToMainRecord.value = false
    }

}