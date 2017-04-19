package com.nvinayshetty.prototypeandroid.listing.di;

import com.nvinayshetty.prototypeandroid.listing.view.ContactListActivity;

import dagger.Subcomponent;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@ContactListScope
@Subcomponent(modules = ContactListModule.class)
public interface ContactListSubComponent {
    void inject(ContactListActivity contactListActivity);
}
