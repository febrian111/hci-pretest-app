package com.hci.pretestapp.common.item

import com.hci.pretestapp.common.extension.UnspecifiedTypeItem
import com.mikepenz.fastadapter.commons.utils.DiffCallbackImpl

interface DiffableListItemType {
    fun itemIdentifier(): Any
    fun comparableContents(): List<Any>
}

class DiffableCallback<Item : UnspecifiedTypeItem> : DiffCallbackImpl<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem is DiffableListItemType && newItem is DiffableListItemType) {
            return oldItem.itemIdentifier() == newItem.itemIdentifier()
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem is DiffableListItemType && newItem is DiffableListItemType) {
            return oldItem.comparableContents().withIndex().none {
                it.value != newItem.comparableContents()[it.index]
            }
        }
        return false
    }

    override fun getChangePayload(
            oldItem: Item, oldItemPosition: Int,
            newItem: Item, newItemPosition: Int): Any? = null

}
