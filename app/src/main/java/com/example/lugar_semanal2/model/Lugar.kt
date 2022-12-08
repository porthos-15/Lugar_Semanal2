package com.example.lugar_semanal2.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parceler

@Parcelize
@Entity(tableName="lugar")
data class Lugar(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre: String?,
    @ColumnInfo(name="correo")
    val correo: String?,
    @ColumnInfo(name="telefono")
    val telefono: String?,
    @ColumnInfo(name="web")
    val web: String?,
    @ColumnInfo(name="latitud")
    val latitud: Double?,
    @ColumnInfo(name="longitud")
    val longitud: Double?,
    @ColumnInfo(name="altura")
    val altura: Double?,
    @ColumnInfo(name="ruta_audio")
    val rutaAudio: String?,
    @ColumnInfo(name="ruta_imagen")
    val rutaImagen: String?
):Parcelable

