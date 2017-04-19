package com.nvinayshetty.prototypeandroid.di;

import com.nvinayshetty.prototypeandroid.listing.di.ContactListSubComponent;
import com.nvinayshetty.prototypeandroid.listing.di.ContactListModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@Singleton
@Component(modules = {AndroidModule.class,AppModule.class})
public interface AppComponent {
    ContactListSubComponent plus(ContactListModule contactListModule);

}
