package com.borbi.boogiemeter.gig

import android.app.Application
import androidx.lifecycle.*
import com.borbi.boogiemeter.database.GigDao

class GigViewModel(
        val database: GigDao,
        application: Application)  : AndroidViewModel(application) {

    private val _navigateToRecording = MutableLiveData<Boolean?>()

    val navigateToRecording: LiveData<Boolean?>
        get() = _navigateToRecording

    fun moveToRecording() {
        _navigateToRecording.value = true
    }

    fun doneMoveToRecording() {
        _navigateToRecording.value = false
    }

    class Factory(
            private val dataSource: GigDao,
            private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GigViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GigViewModel(dataSource, app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}