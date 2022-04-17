package kr.lemonfox.coinmoa.data

import kr.lemonfox.coinmoa.data.base.ApiResponse
import kr.lemonfox.coinmoa.data.model.HomeResponse

interface CoinmoaRepository {
    suspend fun getHome(): ApiResponse<HomeResponse>
}