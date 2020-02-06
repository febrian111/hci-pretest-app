package com.hci.pretestapp.common.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BindableListItemViewHolder<out B : ViewDataBinding>(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    val binding: B = DataBindingUtil.bind(itemView)!!
}
