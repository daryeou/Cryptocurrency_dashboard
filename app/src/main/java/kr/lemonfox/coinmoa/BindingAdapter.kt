package kr.lemonfox.coinmoa

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("srcCompat")
fun ImageView.setSrcCompat(drawable: Drawable?) {
    try {
        drawable?.let {
            setImageDrawable(it)
        }
    } catch (e: Exception) {
        Log.e(null, null, e)
    }
}