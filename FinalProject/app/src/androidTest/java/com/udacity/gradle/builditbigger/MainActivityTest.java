package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.test.mock.MockContext;
import android.util.Log;
import android.widget.Toast;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;

/**
 * Created by rodrigocastro on 11/02/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String TAG_LOG = MainActivityTest.class.getName();


    @Test
    public void tellJoke() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        new EndpointsAsyncTask(new EndpointCallback() {
            @Override
            public void onResultOk(String value) {
                Log.d(TAG_LOG, "the result was: "+ value);
                assertFalse(value.equals(""));
                signal.countDown();
            }

            @Override
            public void onError(String error) {
            }
        }).execute(new Pair<Context, String>(new MockContext(), "Manfred"));
        signal.await();

    }


}