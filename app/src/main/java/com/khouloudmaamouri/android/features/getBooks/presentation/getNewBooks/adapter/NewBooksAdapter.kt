package com.khouloudmaamouri.android.features.getBooks.presentation.getNewBooks.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.khouloudmaamouri.android.databinding.BookItemBinding
import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.Book

class NewBooksAdapter(): RecyclerView.Adapter<NewBooksAdapter.ViewHolder>() {

    lateinit var mContext: Context
    lateinit var itemClick: INewBooksAdapter
    var books = emptyList<BookCacheEntity?>()

    constructor(itemClick: INewBooksAdapter, context: Context) : this() {
        this.itemClick = itemClick
        this.mContext = context
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(mBooks: List<BookCacheEntity?>) {
        this.books = mBooks
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        books[position]?.let { book ->
            holder.binding.bookName.text = book.title
            holder.binding.isbn.text = book.isbn13
            holder.binding.description.text = book.subtitle
            loadImage(book.image,holder)
        }
    }

    class ViewHolder(val binding: BookItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = books.size

    interface INewBooksAdapter {
        fun onItemClickedBook(mBook: Book)
    }

    private fun loadImage(url: String, holder: ViewHolder) {
        Glide.with(mContext)
            .load(url)
            .centerCrop()
            .dontAnimate()
            .override(800, 800)
            .dontTransform()
            .into(holder.binding.imgBook)
    }
}