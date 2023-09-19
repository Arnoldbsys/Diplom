package ru.dombuketa.net_module.entity

import com.google.gson.annotations.SerializedName

data class ApiModelImage(
    @SerializedName("id")
    val id: Int,
    @SerializedName("путь")
    val path: String,
    @SerializedName("имяФайла")
    val fileName: String
)