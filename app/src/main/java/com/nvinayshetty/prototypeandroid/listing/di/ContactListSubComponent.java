package com.nvinayshetty.prototypeandroid.listing.di;

import com.nvinayshetty.prototypeandroid.listing.view.ContactListActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@ContactListScope
@Subcomponent(modules = ContactListModule.class)
public interface ContactListSubComponent  extends AndroidInjector<ContactListActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ContactListActivity> {}

}
