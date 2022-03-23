package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamMembers extends AppCompatActivity {

    RecyclerView recycler;
    TeamlistRecyclerAdapter adapter;
    static Context context1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_members);
        context1=this;


        List<TeamListData> list = new ArrayList<>();
        Intent intent=getIntent();
        int type=intent.getIntExtra("type",0);
        switch (type){
            case Constants.TeamOCType:
                for (int i=0;i<Constants.OCMembPhoto.length;i++)
                {
                    list.add(new TeamListData(Constants.OCMembNames[i],Constants.OCMembPost[i],Constants.OCMembContact[i],Constants.OCMembFacebook[i],Constants.OCMembLinkedin[i],Constants.OCMembEmail[i],Constants.OCMembInsta[i],(Constants.OCMembPhoto[i])));
                }
                break;
            case Constants.TeamTechType:
                for (int i=0;i<Constants.TechMembPhoto.length;i++)
                {
                    list.add(new TeamListData(Constants.TechMembNames[i],Constants.TechMembPost[i],Constants.TechMembContact[i],Constants.TechMembFacebook[i],Constants.TechMembLinkedin[i],Constants.TechMembEmail[i],Constants.TechMembInsta[i],(Constants.TechMembPhoto[i])));
                }
                break;
            default:
        }





        recycler
                = findViewById(
                R.id.teamMemberDetail);
        adapter
                = new TeamlistRecyclerAdapter(
                list, Objects.requireNonNull(getApplication()));
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(
                new LinearLayoutManager(this));



    }

    /*void changeFragment(Fragment fragment)
    {    Fragment mFragment = null;
        mFragment = new OverallCoordisList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_teamList, mFragment).commit();
    }*/

 }
