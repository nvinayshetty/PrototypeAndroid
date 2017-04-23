package com.nvinayshetty.prototypeandroid.error;

import android.content.Context;

/**
 * Created by vinayaprasadn on 21/4/17.
 */

public interface NetworkError {
    String getLocalizedErrorMessageOrDefault(Context context);
    void setErrorMessage(String message);
}
