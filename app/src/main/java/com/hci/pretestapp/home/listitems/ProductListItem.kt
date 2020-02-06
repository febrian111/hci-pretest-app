package com.hci.pretestapp.home.listitems

import android.view.View
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BindableListItemViewHolder
import com.hci.pretestapp.databinding.ListItemMenuProductBinding
import com.hci.pretestapp.home.ProductItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem


class ProductListItem(val viewModel: ProductItemViewModel)
    : AbstractItem<ProductListItem, ProductListItem.ViewHolder>() {

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_menu_product

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.viewmodel = viewModel
        holder.binding.executePendingBindings()
    }

    class ViewHolder(view: View) : BindableListItemViewHolder<ListItemMenuProductBinding>(view)
}
