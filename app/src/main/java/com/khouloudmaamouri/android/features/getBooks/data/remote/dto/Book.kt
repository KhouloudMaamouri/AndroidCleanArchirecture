package com.khouloudmaamouri.android.features.getBooks.data.remote.dto

data class Book(
    val image: String,
    val isbn13: String,
    val price: String,
    val subtitle: String,
    val title: String,
    val url: String
)