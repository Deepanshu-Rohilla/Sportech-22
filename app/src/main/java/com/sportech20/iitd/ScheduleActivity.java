package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.sportech20.iitd.sponsors.SponsorsFragment;

public class ScheduleActivity extends AppCompatActivity implements ScheduleFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
