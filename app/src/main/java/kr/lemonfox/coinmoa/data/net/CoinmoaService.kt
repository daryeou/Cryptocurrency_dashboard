package kr.lemonfox.coinmoa.data.net

import kr.lemonfox.coinmoa.data.model.HomeResponse
import retrofit2.Response

class CoinmoaService(private val coinmoaApi: CoinmoaApi) {

    suspend fun getHome(): Response<HomeResponse> {
        return coinmoaApi.getHome()
    }

}