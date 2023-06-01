package com.khouloudmaamouri.android.di

import android.content.Context
import androidx.room.Room
import com.khouloudmaamouri.android.features.getBooks.data.local.AppDataBase
import com.khouloudmaamouri.android.features.getBooks.data.local.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDataBase {
        val builder = Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java, AppDataBase.DATABASE_NAME
        )
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideBookDao(database: AppDataBase): BookDao {
        return database.bookDao()
    }
}