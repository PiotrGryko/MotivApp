package com.motiv.piotr;

import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.motiv.piotr.dao.LocalStorage;
import java.io.*;
import okhttp3.*;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public class GoRestApiFactory {

    private GoRestApiApi goRestApiApi;
    private static GoRestApi goRestApi;
    private static GoRestApiFactory instance;

    private GoRestApiFactory(final LocalStorage localStorage) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client =
                new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .addInterceptor(
                                new Interceptor() {
                                    @Override
                                    public Response intercept(Chain chain) throws IOException {
                                        Request request =
                                                chain.request()
                                                        .newBuilder()
                                                        .addHeader(
                                                                "Authorization",
                                                                "Bearer Hrw-MtYI1WOCeZiWgUnQqvvG71pKHQVTyQ3F")
                                                        .build();
                                        return chain.proceed(request);
                                    }
                                })
                        .build();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(client)
                        .baseUrl("https://gorest.co.in/public-api/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        goRestApiApi = retrofit.create(GoRestApiApi.class);
        goRestApi = new GoRestApi(goRestApiApi);
    }

    public static GoRestApi getInstance(LocalStorage localStorage) {
        if (instance == null) {
            instance = new GoRestApiFactory(localStorage);
        }
        return instance.goRestApi;
    }
}
