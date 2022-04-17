package kr.lemonfox.coinmoa.data.model

import com.google.gson.annotations.SerializedName

data class Consult (

    @SerializedName("seq")
    val seq: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("context")
    val context: String,

    @SerializedName("regDate")
    val regDate: Long,  // TODO: GsonConverter를 이용하여 Date 타입으로 변경할 것

    @SerializedName("answerCnt")
    val answerCnt: Int,

    @SerializedName("tagList")
    val tagList: List<Tag>,
)
