package com.khouloudmaamouri.android.features.getBooks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

//@TypeConverters(RoomsTypeConverters::class)
@Entity(tableName = "book")
class BookCacheEntity (
    @PrimaryKey(autoGenerate = false)
    val isbn13: String,
    val image: String,
    val price: String,
    val subtitle: String,
    val title: String,
    val url: String
 )