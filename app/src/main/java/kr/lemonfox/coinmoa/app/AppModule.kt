package kr.lemonfox.coinmoa.app

import kr.lemonfox.coinmoa.BuildConfig
import kr.lemonfox.coinmoa.data.CoinmoaRepository
import kr.lemonfox.coinmoa.data.CoinmoaRepositoryImpl
import kr.lemonfox.coinmoa.data.net.CoinmoaApi
import kr.lemonfox.coinmoa.data.net.CoinmoaService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<CoinmoaApi> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinmoaApi::class.java)
    }

    single {
        CoinmoaService(get())
    }

    single<CoinmoaRepository> {
        CoinmoaRepositoryImpl(get())
    }
}