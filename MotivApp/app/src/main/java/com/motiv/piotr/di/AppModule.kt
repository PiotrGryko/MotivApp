 
package com.motiv.piotr.di
import android.app.Application
import androidx.fragment.app.*
import com.google.gson.*
import com.google.gson.annotations.*
import com.google.gson.reflect.*
import com.motiv.piotr.GoRestApi
import com.motiv.piotr.GoRestApiApi
import com.motiv.piotr.dao.DaoRepository
import com.motiv.piotr.dao.LocalStorage
import dagger.*
import dagger.android.*
import dagger.android.support.*
import io.realm.*
import java.io.*
import javax.inject.*
import okhttp3.*
import okhttp3.Response
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
@Module
public class AppModule(private val application: Application) {

    @Provides
    @Singleton

    fun getLocalStorage(): LocalStorage {
        return LocalStorage(application)
    } @Provides
    @Singleton
    fun getGoRestApiApi(localStorage: LocalStorage): GoRestApiApi {
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
        var goRestApiApi = retrofit.create(GoRestApiApi::class.java)

        return goRestApiApi
    } @Provides
    @Singleton
    fun getGoRestApi(goRestApiApi: GoRestApiApi): GoRestApi {
        var goRestApi = GoRestApi(goRestApiApi)

        return goRestApi
    } @Provides
    @Singleton
    fun provideRealmDatabase(): Realm {
        return Realm.getDefaultInstance()
    } @Provides
    @Singleton
    fun getDaoRepository(myDatabase: Realm): DaoRepository {
        return DaoRepository(myDatabase)
    }
}
