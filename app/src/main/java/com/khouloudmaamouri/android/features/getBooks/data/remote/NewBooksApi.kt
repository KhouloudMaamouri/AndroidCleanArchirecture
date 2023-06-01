package com.khouloudmaamouri.android.features.getBooks.data.remote

import com.google.gson.JsonObject
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.NewBooks
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface NewBooksApi {

    @GET("new")
    suspend fun getNewBooks(): Response<NewBooks?>?

//    @POST("")
//    suspend fun setButtons(
//        @Url url: String,
//        @Header("Host") host: String,
//        @Header("Content-Type") contentType: String,
//        @Body params: JsonObject
//    ): Response<String?>?
//
//
//    @DELETE("")
//    suspend fun deleteMapping(
//        @Url url: String,
//        @Header("Host") host: String,
//        @Header("Content-Type") contentType: String,
//        @Query("handlerId" , encoded = true) handlerId: String,
//    ): Response<ResponseBody?>?
}