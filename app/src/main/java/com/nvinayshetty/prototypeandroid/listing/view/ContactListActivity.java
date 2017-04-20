package com.nvinayshetty.prototypeandroid.listing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.nvinayshetty.prototypeandroid.R;
import com.nvinayshetty.prototypeandroid.common.App;
import com.nvinayshetty.prototypeandroid.listing.di.ContactListModule;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.presenter.ContactListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactListActivity extends AppCompatActivity implements ContactsListView{

    @Inject
    ContactListPresenter contactListPresenter;
    @BindView(R.id.contacts_recycler_view)
    RecyclerView contactsRecyclerView;
    private ContactListAdapter contactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App)getApplication()).getAppComponent()
                .plus(new ContactListModule(this))
                .inject(this);
        contactListAdapter=new ContactListAdapter();
        contactsRecyclerView.setAdapter(contactListAdapter);
        contactsRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        contactListPresenter.getContactsList();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showContacts(List<Contact> contacts) {
        contactListAdapter.addAllAndNotify(contacts);
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void displayNotification(String message) {

    }
}
