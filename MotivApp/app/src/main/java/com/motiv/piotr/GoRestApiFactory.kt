 
package com.motiv.piotr
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.piotr.dao.LocalStorage
import java.io.*
import okhttp3.*
import okhttp3.Response
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

public class GoRestApiFactory {

    private var goRestApiApi: GoRestApiApi

    private var goRestApi: GoRestApi

    private var instance: GoRestApiFactory? = null

    constructor(localStorage: LocalStorage) {
        val client = OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain
                        .request()
                        .newBuilder()
                        .addHeader("Authorization", "Bearer Hrw-MtYI1WOCeZiWgUnQqvvG71pKHQVTyQ3F")
                        .build()
                    return chain.proceed(request);
                }
            })
            .build()
        val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public-api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        goRestApiApi = retrofit.create(GoRestApiApi::class.java)
        goRestApi = GoRestApi(goRestApiApi)
    }

    companion object {
        @Volatile private var INSTANCE: GoRestApi? = null
        fun getInstance(localStorage: LocalStorage): GoRestApi =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildInstance(localStorage).also { INSTANCE = it }
            }
        private fun buildInstance(localStorage: LocalStorage) = GoRestApiFactory(localStorage).goRestApi
    }
}
