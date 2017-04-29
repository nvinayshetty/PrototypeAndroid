package com.nvinayshetty.prototypeandroid.di;

import android.app.Activity;

import com.nvinayshetty.prototypeandroid.listing.di.ContactListSubComponent;
import com.nvinayshetty.prototypeandroid.listing.view.ContactListActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by vinayaprasadn on 24/4/17.
 */
@Module(subcomponents = {ContactListSubComponent.class})
public abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(ContactListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(ContactListSubComponent.Builder builder);
}
