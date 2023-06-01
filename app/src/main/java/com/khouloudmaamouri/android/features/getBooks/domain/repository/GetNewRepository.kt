package com.khouloudmaamouri.android.features.getBooks.domain.repository

import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.NewBooks
import retrofit2.Response


interface GetNewRepository {

    suspend fun getNewBooks(): Response<NewBooks?>?
    suspend fun getBooks(): List<BookCacheEntity?>?
    suspend fun saveBooks(books:BookCacheEntity)
}