package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class SportResults extends AppCompatActivity implements MaleResults.OnFragmentInteractionListener,FemaleResults.OnFragmentInteractionListener  {
    ViewPager viewPager;
    TabLayout tabLayout;
    TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_results);

        //Toast.makeText(this, ""+getIntent().getStringExtra("Sport"), Toast.LENGTH_SHORT).show();
        Intent intent=getIntent();
        String sport_name = intent.getStringExtra("Sport");

        viewPager =  findViewById(R.id.view_pager);
        tabLayout =  findViewById(R.id.tab_layout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new MaleResults(), "Men");
        boolean disp_female=true;
        for (int i=0 ;i<Constants.unisexSports.length;i++)
        {
            if(Constants.unisexSports[i].equals(sport_name))
                disp_female=false;
        }
        if (disp_female)
        adapter.addFragment(new FemaleResults(), "Women");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
