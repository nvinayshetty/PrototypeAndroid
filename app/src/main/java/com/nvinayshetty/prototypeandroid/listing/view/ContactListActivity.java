package com.nvinayshetty.prototypeandroid.listing.view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.nvinayshetty.prototypeandroid.R;
import com.nvinayshetty.prototypeandroid.error.NetworkError;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;
import com.nvinayshetty.prototypeandroid.listing.presenter.ContactListPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class ContactListActivity extends AppCompatActivity implements ContactsListView {
    @Inject
    ContactListPresenter contactListPresenter;

    @BindView(R.id.contacts_recycler_view)
    RecyclerView contactsRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.root_layout)
    ConstraintLayout rootLayout;
    private ContactListAdapter contactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        contactListAdapter = new ContactListAdapter();
        contactsRecyclerView.setAdapter(contactListAdapter);
        contactsRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        contactListPresenter.getContactsList();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showContacts(List<Contact> contacts) {
        contactListAdapter.addAllAndNotify(contacts);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayNetworkError(NetworkError networkError) {
        Snackbar.make(rootLayout,networkError.getLocalizedErrorMessageOrDefault(this), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onNoNetwork() {
       Snackbar.make(rootLayout,R.string.please_check_your_internet_connection, Snackbar.LENGTH_LONG).show();
    }


}
