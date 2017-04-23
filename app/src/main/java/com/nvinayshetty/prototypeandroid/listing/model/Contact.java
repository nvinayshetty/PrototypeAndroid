package com.nvinayshetty.prototypeandroid.listing.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinayaprasadn on 18/4/17.
 */
public class Contact{
    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("favorite")
    private boolean isFavorite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getInitials() {
         return String.valueOf(firstName.charAt(0));
    }
}
