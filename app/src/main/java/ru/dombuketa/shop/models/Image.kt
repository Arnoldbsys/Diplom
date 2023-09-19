package ru.dombuketa.shop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image (
    val id: Int,
    val path: String,
    val fileName: String
) : Parcelable
