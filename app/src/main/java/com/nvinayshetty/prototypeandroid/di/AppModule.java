package com.nvinayshetty.prototypeandroid.di;

import android.content.Context;

import com.nvinayshetty.prototypeandroid.common.ErrorHandlingInterceptor;
import com.nvinayshetty.prototypeandroid.mock.MockRetrofit;
import com.nvinayshetty.prototypeandroid.mock.NetworkBehavior;
import com.nvinayshetty.prototypeandroid.prototype.PrototypingInterceptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    @Named("BaseUrl")
    public static String provideBaseUrl() {
        return Urls.BASE_URL;
    }


    @Provides
    @Singleton
    public static OkHttpClient provideLoggingCapableHttpClient(Context context) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(new ErrorHandlingInterceptor(context))
                .addInterceptor(new PrototypingInterceptor(context))
                .addInterceptor(httpLoggingInterceptor)
                .build();


    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient, @Named("BaseUrl") String baseUrl) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public MockRetrofit provideMockRetrofit(Retrofit retrofit){
        final NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setErrorPercent(0);
        behavior.setDelay(4, TimeUnit.SECONDS);
        behavior.setVariancePercent(10);
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit).backgroundExecutor(executor).networkBehavior(behavior).build();
        return mockRetrofit;
    }

}
