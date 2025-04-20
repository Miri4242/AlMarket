package com.example.almarket.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.almarket.data.FakeNotificationApi
import com.example.almarket.model.Notification
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class NotificationsViewModel : ViewModel(){
    var notifications by mutableStateOf<List<Notification>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            notifications = FakeNotificationApi.getNotifications()
        }
    }
}