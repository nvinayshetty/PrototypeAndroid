package com.nvinayshetty.prototypeandroid.listing.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nvinayshetty.prototypeandroid.R;
import com.nvinayshetty.prototypeandroid.listing.model.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinayaprasadn on 19/4/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.contact_initials)
    TextView contactInitials;

    @BindView(R.id.contact_name)
    TextView contactName;

    public ContactViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    public void bind(Contact contact) {
        contactName.setText(contact.getFullName());
        contactInitials.setText(contact.getInitials());
    }
}
