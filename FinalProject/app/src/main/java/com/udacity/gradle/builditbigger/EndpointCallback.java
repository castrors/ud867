package com.udacity.gradle.builditbigger;

/**
 * Created by rodrigocastro on 11/02/17.
 */
public interface EndpointCallback {
    void onResultOk(String value);
    void onError(String error);
}
