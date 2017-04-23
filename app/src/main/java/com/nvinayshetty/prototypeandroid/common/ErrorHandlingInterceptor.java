package com.nvinayshetty.prototypeandroid.common;

import android.content.Context;

import com.nvinayshetty.prototypeandroid.error.UserOfflineException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by vinayaprasadn on 22/4/17.
 */

public class ErrorHandlingInterceptor implements Interceptor {
    private Context context;

    public ErrorHandlingInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(!Utils.isUserOnline(context))
            throw new UserOfflineException();
         return chain.proceed(chain.request());
    }
}
