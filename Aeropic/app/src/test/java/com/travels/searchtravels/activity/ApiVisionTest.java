package com.travels.searchtravels.activity;

import android.net.Uri;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.travels.searchtravels.api.VisionApi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ApiVisionTest {

    final String BEACH_URI = "https://content.skyscnr.com/m/1b51182679225810/original/GettyImages-147444574_doc.jpg?resize=1800px:1800px&quality=100";

    @Test
    public void loadByCategory(String category) {
        MainActivity activity = new MainActivity();
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);

        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.RESUMED);
        scenario.onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                Assert.assertTrue(activity.uploadImage(Uri.parse(BEACH_URI)));
            }
        });
    }

}
