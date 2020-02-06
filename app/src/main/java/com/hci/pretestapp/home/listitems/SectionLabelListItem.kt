package com.hci.pretestapp.home.listitems

import android.view.View
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BindableListItemViewHolder
import com.hci.pretestapp.databinding.ListItemMenuSectionTitleBinding
import com.hci.pretestapp.home.ArticleSectionLableItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem


/**
 * Created by febriansyah on 2020-02-06.
 */

class SectionLabelListItem(val viewModel: ArticleSectionLableItemViewModel)
    : AbstractItem<SectionLabelListItem, SectionLabelListItem.VieHolder>() {

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): VieHolder = VieHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_menu_section_title

    override fun unbindView(holder: VieHolder) {
        super.unbindView(holder)
        holder.binding.viewmodel = viewModel
    }

    class VieHolder(view: View)
        : BindableListItemViewHolder<ListItemMenuSectionTitleBinding>(view)
}
