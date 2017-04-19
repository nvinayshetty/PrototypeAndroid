package com.nvinayshetty.prototypeandroid.listing.presenter;

import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.model.ContactListService;
import com.nvinayshetty.prototypeandroid.listing.view.ContactsListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vinayaprasadn on 18/4/17.
 */

public class ContactListPresenter {
private ContactsListView contactsListView;
private ContactListService contactListService;

    public ContactListPresenter(ContactsListView contactsListView, ContactListService contactListService) {
        this.contactsListView = contactsListView;
        this.contactListService = contactListService;
    }

    public void getContactsList(){
        contactsListView.showProgress();
        contactListService.getContacts().enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contactsListView.hideProgress();
                if(response.isSuccessful()) {
                    final List<Contact> contactList = response.body();
                    contactsListView.showContacts(contactList);
                }

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                contactsListView.hideProgress();

            }
        });
    }
}
