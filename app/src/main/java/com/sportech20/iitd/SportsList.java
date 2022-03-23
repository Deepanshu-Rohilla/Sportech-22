package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sportech20.iitd.newSportFragment.newSportsFrag;

public class SportsList extends AppCompatActivity implements newSportsFrag.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_in_fast);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_list);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
