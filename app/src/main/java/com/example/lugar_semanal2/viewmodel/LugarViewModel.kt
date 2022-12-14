package com.example.lugar_semanal2.viewmodel
import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import com.example.lugar_semanal2.data.LugarDatabase

import com.example.lugar_semanal2.model.Lugar
import com.example.lugar_semanal2.repository.LugarRepository

class LugarViewModel(application: Application) : AndroidViewModel(application){


    private val repository: LugarRepository
    val getLugares: LiveData<List<Lugar>>
    init {
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
        getLugares = repository.getLugares
    }
  fun saveLugar(lugar: Lugar) {
        viewModelScope.launch { repository.saveLugar(lugar) }
    }

    fun deleteLugar(lugar: Lugar) {
        viewModelScope.launch { repository.deleteLugar(lugar) }
    }


}

