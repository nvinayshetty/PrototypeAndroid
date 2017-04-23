package com.nvinayshetty.prototypeandroid.error;

import java.io.IOException;

import retrofit2.HttpException;
import retrofit2.Response;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Created by vinayaprasadn on 21/4/17.
 */

public class ErrorParser {

    public static NetworkErrorType getErrorType(Throwable error){
        if(error instanceof UserOfflineException)
            return NetworkErrorType.NO_INTERNET;
        else if(error instanceof IOException)
            return NetworkErrorType.CONNECTIVITY_ERROR;
        else if(isUnAuthorized(error))
            return NetworkErrorType.UNAUTHENTICATED;
        else return NetworkErrorType.UNEXPECTED_ERROR;

    }

    public  static NetworkErrorType getErrorType(Response response){
        String message=response.message();
        int code = response.code();
        if (code == 401) {
            final NetworkErrorType unAuthenticated = NetworkErrorType.UNAUTHENTICATED;
            unAuthenticated.setErrorMessage(message);
            return unAuthenticated;
        } else if (code >= 400 && code < 500) {
            final NetworkErrorType clientError = NetworkErrorType.CLIENT_ERROR;
            clientError.setErrorMessage(response.message());
            return clientError;
        } else if (code >= 500 && code < 600) {
            final NetworkErrorType serverError = NetworkErrorType.SERVER_ERROR;
            serverError.setErrorMessage(message);
            return serverError;
        } else {
            final NetworkErrorType unexpected = NetworkErrorType.UNEXPECTED_ERROR;
            unexpected.setErrorMessage(message);
            return unexpected;
        }
    }

    private static boolean isUnAuthorized(Throwable error) {
      return  error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }


}
