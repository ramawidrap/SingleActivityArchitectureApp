package com.sibi.loginapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kategori(
    val nama : String,
    val icon : Int,
    val categoryId : String
) : Parcelable