package com.khouloudmaamouri.android.features.getBooks.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mBookCacheEntity: BookCacheEntity): Long

    @Query("SELECT * FROM book")
    suspend fun get(): List<BookCacheEntity>

}