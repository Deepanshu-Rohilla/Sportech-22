package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sportech20.iitd.FirebaseDataHandler.GetScoresData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.getDataFromFirebase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SportsActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    PhotoslistRecyclerAdapter adapter;

    RecyclerView scoresRecyclerView;
    ScoresListRecyclerAdapter scoresAdapter;
    RecyclerView recyclerView2;
    SportsListRecyclerAdapter adapter2;
    List<ScoresListData> listScore = new ArrayList<>();
    DatabaseReference mDataReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        mDataReference = FirebaseDatabase.getInstance().getReference();


        scoresRecyclerView
                = findViewById(
                R.id.homescreen_scorecard);
        scoresAdapter
                = new ScoresListRecyclerAdapter(
                listScore, Objects.requireNonNull(getApplication()));
        scoresRecyclerView.setAdapter(scoresAdapter);
        //     scoresRecyclerView.setLayoutManager(
        //             new LinearLayoutManager(getContext()));
        scoresRecyclerView.setLayoutManager(
                new CustomLinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        getDataFromFirebase gettingData = new getDataFromFirebase();
     /*   gettingData.getSportData("cricket", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("football", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("basketball", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("lawntennis", "male", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("basketball", "female", "live", listScore, scoresAdapter, mDataReference);
        gettingData.getSportData("badminton", "male", "live", listScore, scoresAdapter, mDataReference);
*/
        //gettingData.getSportData("Athletics","female","live",listScore,scoresAdapter,mDataReference);

        GetScoresData.getLiveMatches(listScore,scoresAdapter,mDataReference);
        // For perfect Scrolling
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(scoresRecyclerView);

/*
        // Photos List
        List<PhotosListData> list1 = new ArrayList<>();
        list1 = getData();

        recyclerView
                = (RecyclerView)view.findViewById(
                R.id.photos_list_recycler);
        adapter
                = new PhotoslistRecyclerAdapter(
                list1, Objects.requireNonNull(getActivity().getApplication()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
*/




        //  Recycler View

        List<sportsListData> list2 = new ArrayList<>();
        list2 = getData();

        recyclerView2
                = findViewById(
                R.id.sports_list_recyclerView);
        adapter2
                = new SportsListRecyclerAdapter(
                list2, Objects.requireNonNull(getApplication()));
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(
                new LinearLayoutManager(this));
    }

    private List<sportsListData> getData()
    {
        List<sportsListData> list = new ArrayList<>();
        list.add(new sportsListData("Athletics", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Badminton", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Basketball", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Chess", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Cricket", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Football", (getResources().getDrawable(R.drawable.ic_sports_soccer_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));

        list.add(new sportsListData("Hockey", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Squash", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Tabletennis", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Lawntennis", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Volleyball", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));
        list.add(new sportsListData("Weightlifting", (getResources().getDrawable(R.drawable.ic_sports_basketball_24px)),
                "IITD", "IITK", "2/0", "3/0", "pool", "cricket"));


        return list;
    }

    /*private List<sportsListData> getData()
    {
        List<sportsListData> list = new ArrayList<>();
        list.add(new sportsListData("Athletics",
                "May 23, 2015",
                "Best Of Luck",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Badminton",
                "June 09, 2015",
                "b of l",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Basketball",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Chess",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Cricket",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_cricket_24px)));
        list.add(new sportsListData("Hockey",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_hockey_24px)));
        list.add(new sportsListData("Squash",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Table Tennis",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        list.add(new sportsListData("Tennis",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_tennis_24px)));
        list.add(new sportsListData("Volleyball",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_volleyball_24px)));
        list.add(new sportsListData("WeightLifting",
                "April 27, 2017",
                "This is testing exam ..",getResources().getDrawable(R.drawable.ic_sports_basketball_24px)));
        return list;
    }

    private List<ScoresListData> getDataForScores() {
        List<ScoresListData> list = new ArrayList<>();

        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        list.add(new ScoresListData("Even 120 minutes were not enough to separate winner from IITD and DTU as both ended at 2-2. It was only after penalties that IITD made their way to Finals by winning by 4-2.",getResources().getDrawable(R.mipmap.sportech_theme_foreground),0));
        return list;
    }*/

}
