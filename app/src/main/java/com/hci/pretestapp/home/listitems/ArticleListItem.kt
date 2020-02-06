package com.hci.pretestapp.home.listitems

import android.view.View
import com.hci.auth.model.ArticleModel
import com.hci.pretestapp.R
import com.hci.pretestapp.common.base.BindableListItemViewHolder
import com.hci.pretestapp.databinding.ListItemMenuArticleBinding
import com.hci.pretestapp.home.ArticleItemViewModel
import com.mikepenz.fastadapter.items.AbstractItem

class ArticleListItem(var viewModel: ArticleItemViewModel, val listener: EventListener) :
    AbstractItem<ArticleListItem, ArticleListItem.ViewHolder>(){

    private val clickListener = View.OnClickListener { listener.onClickArticle(viewModel.article) }

    override fun getType(): Int = hashCode()

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    override fun getLayoutRes(): Int = R.layout.list_item_menu_article

    override fun bindView(holder: ViewHolder, payloads: MutableList<Any>) {
        super.bindView(holder, payloads)
        holder.binding.viewmodel = viewModel
        holder.binding.executePendingBindings()

        holder.itemView.setOnClickListener(clickListener)
    }

    class ViewHolder(itemView: View) :
        BindableListItemViewHolder<ListItemMenuArticleBinding>(itemView)

    interface EventListener{
        fun onClickArticle(article: ArticleModel)
    }
}
