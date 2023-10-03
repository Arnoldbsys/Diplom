package ru.dombuketa.shop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category (
    val id: Int,
    val title: String,
    val description: String
) : Parcelable
