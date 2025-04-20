package com.example.almarket.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.almarket.data.FakeVacancyApi
import com.example.almarket.model.Vacancy
import kotlinx.coroutines.launch

class VacanciesViewModel : ViewModel() {

    var vacancies by mutableStateOf<List<Vacancy>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            vacancies = FakeVacancyApi.getVacancies()
        }
    }
}