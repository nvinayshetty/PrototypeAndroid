package com.nvinayshetty.prototypeandroid.listing.presenter;

import com.nvinayshetty.prototypeandroid.error.ErrorParser;
import com.nvinayshetty.prototypeandroid.error.NetworkErrorType;
import com.nvinayshetty.prototypeandroid.error.NetworkError;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.model.NetworkCallBack;
import com.nvinayshetty.prototypeandroid.listing.view.ContactsListView;

import java.util.List;

/**
 * Created by vinayaprasadn on 18/4/17.
 */

public class ContactListPresenter {
    private ContactsListView contactsListView;
    private ContactListNetworkModel contactListNetworkModel;

    public ContactListPresenter(ContactsListView contactsListView,  ContactListNetworkModel contactListNetworkModel) {
        this.contactsListView = contactsListView;
        this.contactListNetworkModel = contactListNetworkModel;
    }

    public void getContactsList(){
        contactsListView.showProgress();
        contactListNetworkModel.getContactsList(new NetworkCallBack<List<Contact>>() {

            @Override
            public void onSuccess(List<Contact> response) {
                contactsListView.showContacts(response);
                contactsListView.hideProgress();
            }

            @Override
            public void onError(Throwable t) {
                final NetworkErrorType errorType = ErrorParser.getErrorType(t);
                if(errorType==NetworkErrorType.NO_INTERNET)
                    contactsListView.onNoNetwork();
                else
                    contactsListView.displayNetworkError(errorType);
                contactsListView.hideProgress();

            }

            @Override
            public void onErrorResponse(NetworkError networkError) {
                contactsListView.displayNetworkError(networkError);
                contactsListView.hideProgress();
            }

        });
    }


}
