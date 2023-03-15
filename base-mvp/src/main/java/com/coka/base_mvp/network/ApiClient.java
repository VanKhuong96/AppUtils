package com.coka.base_mvp.network;

import android.util.Log;

import com.coka.base_mvp.BuildConfig;
import com.coka.base_mvp.Utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static String baseURL = "";

    public static class AuthenticationInterceptor implements Interceptor {
        private final String mToken;
        public AuthenticationInterceptor(String token) {
            this.mToken = token;
        }


        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder()
                    .header("Token", mToken);
            Request request = builder.build();
            return chain.proceed(request);
        }
    }
    public static Retrofit getClient(String token, String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectionSpecs(Arrays.asList(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        okHttpClient.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClient.readTimeout(30, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(30, TimeUnit.SECONDS);
        AuthenticationInterceptor authenticationInterceptor;
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor);
        }
        if (StringUtils.isNotEmpty(token)) {
            authenticationInterceptor = new AuthenticationInterceptor(token);
            okHttpClient.addInterceptor(authenticationInterceptor);
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new ErrorHandlingAdapter.ErrorHandlingCallAdapterFactory())
                .build();
        return retrofit;
    }
}
