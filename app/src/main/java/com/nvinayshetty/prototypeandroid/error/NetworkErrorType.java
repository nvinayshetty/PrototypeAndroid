package com.nvinayshetty.prototypeandroid.error;

import android.content.Context;

import com.nvinayshetty.prototypeandroid.R;

/**
 * Created by vinayaprasadn on 21/4/17.
 */

public enum NetworkErrorType implements NetworkError {

    CONNECTIVITY_ERROR{
        private String message;
        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
                return context.getResources().getString(R.string.connectivity_error);
            return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    },
    NO_INTERNET {
        private String message;
        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
            return context.getResources().getString(R.string.please_check_your_internet_connection);
            return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    }, SERVER_ERROR {
        private String message;

        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
                return context.getResources().getString(R.string.server_error);
            return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    }, CLIENT_ERROR {
        private String message;

        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
                return context.getResources().getString(R.string.oops_something_went_wrong);
            return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    }, UNEXPECTED_ERROR {
        private String message;

        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
                return context.getResources().getString(R.string.something_went_wrong);
            return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    }, UNAUTHENTICATED {
        private String message;

        @Override
        public String getLocalizedErrorMessageOrDefault(Context context) {
            if (message == null || message.isEmpty())
                return context.getResources().getString(R.string.un_authorized_message);
            else return message;
        }

        @Override
        public void setErrorMessage(String message) {
            this.message = message;
        }
    }
}
