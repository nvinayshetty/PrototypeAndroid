package com.nvinayshetty.prototypeandroid.di;

import android.content.Context;

import com.nvinayshetty.prototypeandroid.common.ErrorHandlingInterceptor;
import com.nvinayshetty.prototypeandroid.prototype.PrototypingInterceptor;

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
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new ErrorHandlingInterceptor(context))
                .addInterceptor(new PrototypingInterceptor(context))
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

}
