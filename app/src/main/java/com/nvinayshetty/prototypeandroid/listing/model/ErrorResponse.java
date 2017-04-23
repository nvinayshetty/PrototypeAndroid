package com.nvinayshetty.prototypeandroid.listing.model;

/**
 * Created by vinayaprasadn on 20/4/17.
 */

public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
