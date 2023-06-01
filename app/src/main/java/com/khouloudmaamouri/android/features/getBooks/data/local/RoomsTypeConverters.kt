package com.khouloudmaamouri.android.features.getBooks.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


//class RoomsTypeConverters {
//    @TypeConverter
//    fun jsonToListRoomCacheEntity(json: String?): ArrayList<AreaCacheEntity>? {
//        val gson = Gson()
//        val type: Type? = object : TypeToken<ArrayList<AreaCacheEntity>>() {}.type
//        return gson.fromJson(json, type)
//    }
//
//    @TypeConverter
//    fun listRoomCacheEntityToJson(list: ArrayList<AreaCacheEntity?>?): String? {
//        val gson = Gson()
//        val type: Type? = object : TypeToken<ArrayList<AreaCacheEntity>>() {}.type
//        return gson.toJson(list, type)
//    }
//}