package com.nvinayshetty.prototypeandroid.prototype;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by vinayaprasadn on 16/4/17.
 */

public class PrototypingInterceptor implements Interceptor {
    private Context context;

    public PrototypingInterceptor(Context context) {
        this.context = context;
    }


    public String readFromFile(String fileName) throws IOException {
        InputStream inputStream = context.getResources().getAssets().open(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonString.append(line);
        }
        return jsonString.toString();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final String url = chain.request().url().toString();
        switch (url) {
            case "http://10.42.0.1:3000/contacts": {
                final ResponseBody responseBody = ResponseBody
                        .create(MediaType.parse("application/json"), readFromFile("contacts_response.json"));
                final Response response = new Response
                        .Builder()
                        .body(responseBody)
                        .request(chain.request()).message("OK")
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .build();
                return response;
            }
        }
        return chain.proceed(chain.request());
    }
}
