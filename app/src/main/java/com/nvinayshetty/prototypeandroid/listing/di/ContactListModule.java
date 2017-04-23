package com.nvinayshetty.prototypeandroid.listing.di;

import android.content.Context;

import com.nvinayshetty.prototypeandroid.listing.model.ContactListService;
import com.nvinayshetty.prototypeandroid.listing.presenter.ContactListNetworkModel;
import com.nvinayshetty.prototypeandroid.listing.presenter.ContactListPresenter;
import com.nvinayshetty.prototypeandroid.listing.view.ContactsListView;
import com.nvinayshetty.prototypeandroid.mock.BehaviorDelegate;
import com.nvinayshetty.prototypeandroid.mock.MockRetrofit;
import com.nvinayshetty.prototypeandroid.prototype.listing.MockContactService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinayaprasadn on 19/4/17.
 */
@Module
public class ContactListModule {
    private ContactsListView contactsListView;

    public ContactListModule(ContactsListView contactsListView) {
        this.contactsListView = contactsListView;
    }

    @Provides
    public ContactsListView provideContactListView(){
        return contactsListView;
    }

    @Provides
    public static ContactListService provideContactListService(MockRetrofit retrofit, Context context){
        final BehaviorDelegate<ContactListService> mockContactsServiceBehaviorDelegate = retrofit.create(ContactListService.class);
        return new MockContactService(context,mockContactsServiceBehaviorDelegate);
    }

    @Provides
    public static ContactListNetworkModel provideContactListNetworkService(ContactListService contactListService){
        return new ContactListNetworkModel(contactListService);
    }
    @Provides
    public static ContactListPresenter provideContactListPresenter(ContactsListView contactsListView,ContactListNetworkModel contactListService){
        return new ContactListPresenter(contactsListView,contactListService);
    }
}
