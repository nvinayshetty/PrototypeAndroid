package com.nvinayshetty.prototypeandroid.common;

import android.app.Activity;
import android.app.Application;

import com.frogermcs.androiddevmetrics.AndroidDevMetrics;
import com.nvinayshetty.prototypeandroid.di.AndroidModule;
import com.nvinayshetty.prototypeandroid.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

/**
 * Created by vinayaprasadn on 19/4/17.
 */

public class App extends Application implements HasDispatchingActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().androidModule(new AndroidModule(this)).build().inject(this);
        AndroidDevMetrics.initWith(this);
    }



    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
