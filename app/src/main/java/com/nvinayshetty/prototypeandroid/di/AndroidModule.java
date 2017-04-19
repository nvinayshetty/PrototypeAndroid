package com.nvinayshetty.prototypeandroid.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@Module
public class AndroidModule {
    private final Application application;

    public AndroidModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }
}
