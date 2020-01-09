package com.boltt.health.api;

import com.boltt.health.constant.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {

    static  HttpLoggingInterceptor logging = new HttpLoggingInterceptor();


    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS).addInterceptor(logging)
            .build();



    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build();


    private static final ApiCall service = retrofit.create(ApiCall.class);

    public static ApiCall getService() {
        return service;
    }
}
