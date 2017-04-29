package com.nvinayshetty.prototypeandroid.di;

import com.nvinayshetty.prototypeandroid.common.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@Singleton
@Component(modules = {AndroidModule.class,AppModule.class, AndroidInjectionModule.class,ActivityModule.class})
public interface AppComponent {
    void inject(App application);
}
