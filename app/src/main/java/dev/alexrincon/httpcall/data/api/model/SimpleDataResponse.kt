package dev.alexrincon.httpcall.data.api.model

import com.google.gson.annotations.SerializedName

data class SimpleDataResponse (
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("completed")
    val completed: Boolean
)
