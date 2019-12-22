package com.motiv.piotr.di;

import android.app.Application;
import android.os.Handler;
import androidx.fragment.app.*;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.motiv.piotr.GoRestApi;
import com.motiv.piotr.GoRestApiApi;
import com.motiv.piotr.dao.DaoRepository;
import com.motiv.piotr.dao.LocalStorage;
import com.motiv.piotr.dao.MyRoomDatabase;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;
import okhttp3.*;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public LocalStorage getLocalStorage() {

        return new LocalStorage(application);
    }

    @Provides
    @Singleton
    public GoRestApiApi getGoRestApiApi(final LocalStorage localStorage) {

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
        GoRestApiApi goRestApiApi = retrofit.create(GoRestApiApi.class);

        return goRestApiApi;
    }

    @Provides
    @Singleton
    public GoRestApi getGoRestApi(GoRestApiApi goRestApiApi) {
        GoRestApi goRestApi = new GoRestApi(goRestApiApi);
        return goRestApi;
    }

    @Provides
    public Handler provideHandler() {
        return new Handler(application.getMainLooper());
    }

    @Provides
    @Singleton
    public MyRoomDatabase provideMyRoomDatabase() {
        return Room.databaseBuilder(application, MyRoomDatabase.class, MyRoomDatabase.DATABASE_NAME)
                .build();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {

        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        final int KEEP_ALIVE_TIME = 1;
        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        BlockingQueue<Runnable> mDecodeWorkQueue = new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                mDecodeWorkQueue);
    }

    @Provides
    @Singleton
    public DaoRepository getDaoRepository(
            Handler handler, MyRoomDatabase myRoomDatabase, Executor executor) {
        return new DaoRepository(handler, myRoomDatabase, executor);
    }
}
