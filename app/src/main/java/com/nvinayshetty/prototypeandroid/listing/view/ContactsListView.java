package com.nvinayshetty.prototypeandroid.listing.view;

import com.nvinayshetty.prototypeandroid.listing.model.Contact;

import java.util.List;

/**
 * Created by vinayaprasadn on 18/4/17.
 */

public interface ContactsListView {
    void showProgress();
    List<Contact> showContacts(List<Contact> contacts);
    void hideProgress();
}
