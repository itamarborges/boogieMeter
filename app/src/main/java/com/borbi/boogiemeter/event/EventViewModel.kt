package com.borbi.boogiemeter.event

import android.app.Application
import androidx.lifecycle.*

class EventViewModel(application: Application)  : AndroidViewModel(application) {

    private val _navigateToRecording = MutableLiveData<Boolean?>()

    val navigateToRecording: LiveData<Boolean?>
        get() = _navigateToRecording

    fun moveToRecording() {
        _navigateToRecording.value = true
    }

    fun doneMoveToRecording() {
        _navigateToRecording.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EventViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}