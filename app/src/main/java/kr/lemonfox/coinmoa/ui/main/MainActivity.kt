package kr.lemonfox.coinmoa.ui.main

import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.lemonfox.coinmoa.common.BaseActivity
import kr.lemonfox.coinmoa.data.CoinmoaRepository
import kr.lemonfox.coinmoa.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity: BaseActivity() {
    companion object {
        val TAG: String = "MainActivity"
    }

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val repository: CoinmoaRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "MainActivity - onCreate() called${repository.getHome().responseData.toString()}")
        }
    }
}