package com.khouloudmaamouri.android.features.getBooks.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BookCacheEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        const val DATABASE_NAME: String = "DB_BOOKS"
    }

}
