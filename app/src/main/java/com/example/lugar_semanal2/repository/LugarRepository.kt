package com.example.lugar_semanal2.repository

import androidx.lifecycle.LiveData
import com.example.lugar_semanal2.data.LugarDao
import com.example.lugar_semanal2.model.Lugar


class LugarRepository(private val lugarDao: LugarDao) {
    suspend fun saveLugar(lugar: Lugar){
        if (lugar.id==0){ // es un lugar nuevo... se inserta
            lugarDao.addLugar(lugar)

        }else{
            lugarDao.updateLugar(lugar)


        }

    }


    suspend fun deleteLugar(lugar: Lugar) {
        lugarDao.deleteLugar(lugar)
    }
    val getLugares : LiveData<List<Lugar>> = lugarDao.getLugares()
}