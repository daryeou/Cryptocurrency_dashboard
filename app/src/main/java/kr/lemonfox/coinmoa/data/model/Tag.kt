package kr.lemonfox.coinmoa.data.model

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("key")
    val key: Int,

    @SerializedName("name")
    val name: String,
)
