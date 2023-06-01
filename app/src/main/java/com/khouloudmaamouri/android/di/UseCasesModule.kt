package com.khouloudmaamouri.android.di

import com.khouloudmaamouri.android.features.getBooks.domain.repository.GetNewRepository
import com.khouloudmaamouri.android.features.getBooks.domain.useCases.GetNewBooksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideGetNewBooksUseCase(repository: GetNewRepository) =
        GetNewBooksUseCase(repository)
}