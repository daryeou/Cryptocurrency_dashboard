package kr.lemonfox.coinmoa.data.model

import com.google.gson.annotations.SerializedName

data class Expert(
    @SerializedName("name")
    val name: String,

    @SerializedName("typeName")
    val type: String,

    @SerializedName("companyName")
    val company: String,

    @SerializedName("profileImagePath")
    val imgUrl: String,

    @SerializedName("tagList")
    val tagList: List<Tag>
)
