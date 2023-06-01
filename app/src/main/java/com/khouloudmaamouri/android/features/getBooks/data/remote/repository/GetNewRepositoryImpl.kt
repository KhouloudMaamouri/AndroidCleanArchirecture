package com.khouloudmaamouri.android.features.getBooks.data.remote.repository

import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.data.local.BookDao
import com.khouloudmaamouri.android.features.getBooks.data.remote.NewBooksApi
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.NewBooks
import com.khouloudmaamouri.android.features.getBooks.domain.repository.GetNewRepository
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import retrofit2.Response
import javax.inject.Inject


class GetNewRepositoryImpl @Inject constructor(
    private val service: NewBooksApi,
    private val bookDao: BookDao
): GetNewRepository {

    override suspend fun getNewBooks(): Response<NewBooks?>? = service.getNewBooks()

    override suspend fun getBooks(): List<BookCacheEntity?> {
      return bookDao.get()
    }

    override suspend fun saveBooks(books: BookCacheEntity) {
        bookDao.insert(books)
    }
}