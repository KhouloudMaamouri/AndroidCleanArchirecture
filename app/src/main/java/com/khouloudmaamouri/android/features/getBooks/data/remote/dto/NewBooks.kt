package com.khouloudmaamouri.android.features.getBooks.data.remote.dto

data class NewBooks(
    val books: List<Book>,
    val error: String,
    val total: String
)