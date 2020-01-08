package com.example.step2websoft.olshopgue.Net;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIUrl {
    private static final String BASE_URL = "https://olshopgue.com/webservices/Api/";
    private static Retrofit retrofit;
    private static OkHttpClient getRequestHeader(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().readTimeout(1000,TimeUnit.SECONDS)
                .connectTimeout(1000,TimeUnit.SECONDS)
                .writeTimeout(100,TimeUnit.SECONDS).build();
        return okHttpClient;
    }

    private static Retrofit provideRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getRequestHeader())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

    private static APIService service = provideRetrofit().create(APIService.class);

    public static APIService provideApiService() {
        return service;
    }
}
