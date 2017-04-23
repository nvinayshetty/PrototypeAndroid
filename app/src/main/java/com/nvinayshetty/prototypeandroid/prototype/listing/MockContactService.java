package com.nvinayshetty.prototypeandroid.prototype.listing;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nvinayshetty.prototypeandroid.common.Utils;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.model.ContactListService;
import com.nvinayshetty.prototypeandroid.mock.BehaviorDelegate;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by vinayaprasadn on 23/4/17.
 */

public class MockContactService implements ContactListService {
    private Context context;
    private final BehaviorDelegate<ContactListService> behaviorDelegate;
    private  List<Contact> contacts;

    public MockContactService(Context context,BehaviorDelegate behaviorDelegate) {
        this.context = context;
        this.behaviorDelegate = behaviorDelegate;
        this.contacts = new ArrayList<>();
    }

    @Override
    public Call<List<Contact>> getContacts() {
        try {
            final String fromJsonFile = Utils.readFromJsonFile(context, "contacts_response.json");
            Type listType = new TypeToken<List<Contact>>(){}.getType();
            contacts = new Gson().fromJson(fromJsonFile, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return behaviorDelegate.returningResponse(contacts).getContacts();

    }
}
