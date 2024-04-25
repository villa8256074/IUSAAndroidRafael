package com.example.iusademoapp.model.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MotoResponse(@SerializedName("ok")var status: Boolean, var usuario: String, var motos: List<MotoDAO>)