package kr.lemonfox.coinmoa.data.net

import kr.lemonfox.coinmoa.data.model.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoinmoaApi {
    @GET("api/home.json")
    suspend fun getHome(): Response<HomeResponse>
}