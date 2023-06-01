package com.khouloudmaamouri.android.di

import com.khouloudmaamouri.android.features.getBooks.data.local.BookDao
import com.khouloudmaamouri.android.features.getBooks.data.remote.NewBooksApi
import com.khouloudmaamouri.android.features.getBooks.data.remote.repository.GetNewRepositoryImpl
import com.khouloudmaamouri.android.features.getBooks.domain.repository.GetNewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGetNewRepository(
      service: NewBooksApi,
      bookDao: BookDao
    ): GetNewRepository {
        return GetNewRepositoryImpl(service, bookDao)
    }

}