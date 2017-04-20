package com.nvinayshetty.prototypeandroid.listing.di;

import com.nvinayshetty.prototypeandroid.listing.model.ContactListService;
import com.nvinayshetty.prototypeandroid.listing.presenter.ContactListPresenter;
import com.nvinayshetty.prototypeandroid.listing.view.ContactsListView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
    public static ContactListService provideContactListService(Retrofit  retrofit){
        return retrofit.create(ContactListService.class);
    }

    @Provides
    public static ContactListPresenter provideContactListPresenter(ContactsListView contactsListView,ContactListService contactListService){
        return new ContactListPresenter(contactsListView,contactListService);
    }
}
