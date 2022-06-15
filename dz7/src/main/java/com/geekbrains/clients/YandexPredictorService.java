package com.geekbrains.clients;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.geekbrains.clients.RetrofitCallExecutor.executeCall;

public class YandexPredictorService {

    private static final String API_KEY = "pdct.1.1.20220518T172109Z.e748ac891d91b060.05352147d8955a46b077d7eb62696ed2db38447c";
    private final YandexPredictorApi api;

    public YandexPredictorService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(System.out::println);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        api = new Retrofit.Builder()
                .baseUrl("https://predictor.yandex.net/api/v1/predict.json/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YandexPredictorApi.class);
    }

    public List<String> getLangs() {
        return executeCall(api.getLangs(API_KEY));
    }

    public PredictorResult complete(String query, String lang, Integer limit) {
        return executeCall(api.complete(API_KEY, query, lang, limit));
    }
}
