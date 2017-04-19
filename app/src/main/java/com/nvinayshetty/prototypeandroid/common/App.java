package com.nvinayshetty.prototypeandroid.common;

import android.app.Application;

import com.nvinayshetty.prototypeandroid.di.AndroidModule;
import com.nvinayshetty.prototypeandroid.di.AppComponent;
import com.nvinayshetty.prototypeandroid.di.AppModule;
import com.nvinayshetty.prototypeandroid.di.DaggerAppComponent;

/**
 * Created by vinayaprasadn on 19/4/17.
 */

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule(this))
                .appModule(new AppModule())
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
