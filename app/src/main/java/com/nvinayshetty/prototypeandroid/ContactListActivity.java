package com.nvinayshetty.prototypeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.view.ContactsListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListActivity extends AppCompatActivity implements ContactsListView{

    @BindView(R.id.contacts_recycler_view)
    RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public List<Contact> showContacts(List<Contact> contacts) {
        return null;
    }

    @Override
    public void hideProgress() {

    }
}
