package ru.dombuketa.shop.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    val id: Int,
    val name: String,
    val imageCart: String,
    val imageGalary: String,
    val description: String,
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var  isInFavorites: Boolean = false
) : Parcelable
