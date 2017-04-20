package com.nvinayshetty.prototypeandroid.listing.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nvinayshetty.prototypeandroid.R;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinayaprasadn on 19/4/17.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private List<Contact> contacts=new ArrayList<>();

    public void addAllAndNotify(List<Contact> contactsList){
        contacts.addAll(contactsList);
        notifyDataSetChanged();
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
