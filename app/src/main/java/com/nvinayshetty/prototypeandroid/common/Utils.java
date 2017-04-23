package com.nvinayshetty.prototypeandroid.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vinayaprasadn on 22/4/17.
 */

public class Utils {
    public static boolean isUserOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    public static String readFromJsonFile(Context context,String fileName) throws IOException {
        InputStream inputStream = context.getResources().getAssets().open(fileName, Context.MODE_WORLD_READABLE);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonString.append(line);
        }
        return jsonString.toString();
    }
}
