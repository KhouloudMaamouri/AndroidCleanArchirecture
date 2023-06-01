package com.khouloudmaamouri.android.features.getBooks.domain.useCases

import com.khouloudmaamouri.android.core.Resource
import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheMapper
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.Book
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.NewBooks
import com.khouloudmaamouri.android.features.getBooks.domain.repository.GetNewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class GetNewBooksUseCase @Inject constructor(
    private val repository: GetNewRepository
) {

    suspend fun invoke(): Flow<Resource<List<BookCacheEntity?>?>> = flow {
        try {
            emit(Resource.Loading<List<BookCacheEntity?>?>())
            val result = repository.getNewBooks()
            saveBookIntoCache(result)
            val booksCache = repository.getBooks()
            emit(Resource.Success(booksCache))
        } catch (e: HttpException) {
            val booksCache = repository.getBooks()
            when(booksCache.isNullOrEmpty()){
                true -> emit(Resource.Error(e.message.toString()))
                false -> emit(Resource.Success(booksCache))
            }
        }catch (e:java.lang.Exception){
            val booksCache = repository.getBooks()
            when(booksCache.isNullOrEmpty()){
                true -> emit(Resource.Error(e.message.toString()))
                false -> emit(Resource.Success(booksCache))
            }
        }
    }

    private suspend fun saveBookIntoCache(rep: Response<NewBooks?>?){
        rep?.let {
            it.body()?.let { newBooks ->
                newBooks.books.map { book: Book ->
                    repository.saveBooks(BookCacheMapper().mapFromDomainModel(book))
                }
            }
        }
    }

}