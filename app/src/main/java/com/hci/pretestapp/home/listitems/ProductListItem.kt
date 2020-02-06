package com.hci.pretestapp.home.listitems

import android.view.View
import com.hci.auth.model.ProductModel
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BindableListItemViewHolder
import com.hci.pretestapp.databinding.ListItemMenuProductBinding
import com.hci.pretestapp.home.ProductItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem


class ProductListItem(val viewModel: ProductItemViewModel, val listener: EventListener)
    : AbstractItem<ProductListItem, ProductListItem.ViewHolder>() {

    private val clickListener = View.OnClickListener { listener.onClickProduct(viewModel.product) }

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_menu_product

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.viewmodel = viewModel
        holder.binding.executePendingBindings()

        holder.itemView.setOnClickListener(clickListener)
    }

    class ViewHolder(view: View) : BindableListItemViewHolder<ListItemMenuProductBinding>(view)

    interface EventListener {
        fun onClickProduct(product: ProductModel)
    }
}
