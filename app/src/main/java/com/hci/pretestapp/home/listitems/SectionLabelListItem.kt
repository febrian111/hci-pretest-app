package com.hci.pretestapp.home.listitems

import android.view.View
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BindableListItemViewHolder
import com.hci.pretestapp.databinding.ListItemMenuSectionTitleBinding
import com.hci.pretestapp.home.ArticleSectionLableItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem


class SectionLabelListItem(private var viewModel: ArticleSectionLableItemViewModel) :
    AbstractItem<SectionLabelListItem, SectionLabelListItem.ViewHolder>(){

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_menu_section_title

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.viewmodel = viewModel
        holder.binding.executePendingBindings()
    }

    class ViewHolder(itemView: View) :
        BindableListItemViewHolder<ListItemMenuSectionTitleBinding>(itemView)
}
