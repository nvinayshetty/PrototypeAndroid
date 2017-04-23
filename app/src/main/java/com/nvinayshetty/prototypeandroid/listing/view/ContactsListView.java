package com.nvinayshetty.prototypeandroid.listing.view;

import com.nvinayshetty.prototypeandroid.error.NetworkError;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;

import java.util.List;

/**
 * Created by vinayaprasadn on 18/4/17.
 */

public interface ContactsListView {
    void showProgress();
    void showContacts(List<Contact> contacts);
    void hideProgress();
    void displayNetworkError(NetworkError message);
    void onNoNetwork();
}
