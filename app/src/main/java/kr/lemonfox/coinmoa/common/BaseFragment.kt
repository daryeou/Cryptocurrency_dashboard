package kr.lemonfox.coinmoa.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kr.lemonfox.coinmoa.utils.autoCleared

abstract class BaseFragment<T: ViewDataBinding>(): Fragment()  {
    private var binding by autoCleared<T>()
    abstract val resId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        return binding.root
    }

    fun getViewBinding(): T{
        return binding
    }

    override fun onDestroyView() {
        // _binding = null
        super.onDestroyView()
    }
}