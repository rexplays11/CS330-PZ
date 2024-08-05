package com.example.cs330_pz_3929.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val _speed = MutableStateFlow<Long>(1000)
    val speed: StateFlow<Long> = _speed

    private val _size = MutableStateFlow<Int>(40)
    val size: StateFlow<Int> = _size

    fun updateSpeed(newSpeed: Long) {
        _speed.value = newSpeed
    }

    fun updateSize(newSize: Int) {
        _size.value = newSize
    }

    fun saveSettings(onSave: (Long, Int) -> Unit) {
        viewModelScope.launch {
            onSave(_speed.value, _size.value)
        }
    }
}