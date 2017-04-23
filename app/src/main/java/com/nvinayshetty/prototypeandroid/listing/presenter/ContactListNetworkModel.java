package com.nvinayshetty.prototypeandroid.listing.presenter;

import com.nvinayshetty.prototypeandroid.error.ErrorParser;
import com.nvinayshetty.prototypeandroid.error.NetworkErrorType;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.model.ContactListService;
import com.nvinayshetty.prototypeandroid.listing.model.NetworkCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactListNetworkModel {
 private ContactListService contactListService;

    public ContactListNetworkModel(ContactListService contactListService) {
        this.contactListService = contactListService;
    }

    public void getContactsList( NetworkCallBack networkCallBack) {
        contactListService.getContacts().enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if (response.isSuccessful()) {
                    final List<Contact> contactList = response.body();
                    networkCallBack.onSuccess(contactList);
                }else {
                    final NetworkErrorType networkError = ErrorParser.getErrorType(response);
                    networkCallBack.onErrorResponse(networkError);
                }


            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
               networkCallBack.onError(t);
            }
        });
    }
}