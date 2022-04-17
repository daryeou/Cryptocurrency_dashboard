package kr.lemonfox.coinmoa.data

import kr.lemonfox.coinmoa.data.base.ApiResponse
import kr.lemonfox.coinmoa.data.model.HomeResponse
import kr.lemonfox.coinmoa.data.net.CoinmoaService
import retrofit2.Response

class CoinmoaRepositoryImpl(private val coinmoaService: CoinmoaService) : CoinmoaRepository {
    override suspend fun getHome(): ApiResponse<HomeResponse> {
        return getApiResponse { coinmoaService.getHome() }
    }

    private suspend fun <T> getApiResponse(call: suspend () -> Response<T>): ApiResponse<T> {
        val response = call()
        return try {
            if (response.isSuccessful) {
                val body = response.body()
                ApiResponse.success(body)
            } else {
                ApiResponse.error(response.code())
            }
        } catch (e: Exception) {
            ApiResponse.error(null)
        }
    }
}