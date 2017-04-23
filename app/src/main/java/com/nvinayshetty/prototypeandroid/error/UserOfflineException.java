package com.nvinayshetty.prototypeandroid.error;

import java.io.IOException;

/**
 * Created by vinayaprasadn on 22/4/17.
 */

public class UserOfflineException extends IOException {

    @Override
    public String getMessage() {
        return "Please check network connectivity";
    }
}
