package com.hci.pretestapp.common.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**
 * Created by febriansyah on 2020-02-06.
 */

@BindingAdapter("app:imageUrl")
fun setImageUrl(view: AppCompatImageView, url: String) {
    Glide.with(view.context).load(url).into(view)
}
