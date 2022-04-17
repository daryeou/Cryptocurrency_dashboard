package kr.lemonfox.coinmoa.data.model

import com.google.gson.annotations.SerializedName

data class HomeResponse (

    @SerializedName("pageMap")
    val pageMap: PageMap,

    @SerializedName("expertListPosition")
    val expertsPosition: Int,

    @SerializedName("companyListPosition")
    val companiesPosition: Int,

    @SerializedName("consultList")
    val consultList: List<Consult>,

    @SerializedName("expertList")
    val expertList: List<Expert>,

    @SerializedName("companyList")
    val companyList: List<Company>
)

data class PageMap (

    @SerializedName("pageNumber")
    val pageNum: Int,

    @SerializedName("rowPerPage")
    val rowPerPage: Int,

    @SerializedName("pageCount")
    val pageCnt: Int,

    @SerializedName("totalCount")
    val totalCnt: Int
)
