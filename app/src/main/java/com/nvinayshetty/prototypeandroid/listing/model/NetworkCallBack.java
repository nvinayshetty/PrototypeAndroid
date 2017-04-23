package com.nvinayshetty.prototypeandroid.listing.model;

import com.nvinayshetty.prototypeandroid.error.NetworkError;

/**
 * Created by vinayaprasadn on 21/4/17.
 */

public interface NetworkCallBack<T>{
    void onSuccess(T response);
    void onError(Throwable t);
    void onErrorResponse(NetworkError networkError);
}
