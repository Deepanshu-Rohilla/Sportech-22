package com.sportech20.iitd.FirebaseDataHandler;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.sportech20.iitd.Constants;
import com.sportech20.iitd.FemaleResults;
import com.sportech20.iitd.MaleResults;
import com.sportech20.iitd.ScoresListData;
import com.sportech20.iitd.ScoresListRecyclerAdapter;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListRecyclerAdapter;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.MaleSportResultListData;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.MaleSportResultListRecyclerAdapter;
import com.sportech20.iitd.com.sportech20.iitd.sportResult.getDataFromFirebase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class GetScoresData {
    public static void getLiveMatches(List<ScoresListData> listScore, ScoresListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference)
    {
        getDataFromFirebase gettingData=new getDataFromFirebase();
        for(int i=0;i< Constants.allSportsname.length;i++){
            gettingData.getSportData(Constants.allSportsname[i],"male","live",listScore,scoresAdapter,mDataReference);
            gettingData.getSportData(Constants.allSportsname[i],"female","live",listScore,scoresAdapter,mDataReference);

        }
    }

    public static void getLiveMatches(List<ScoresListData> listScore,ScoresListRecyclerAdapter scoresAdapter,DatabaseReference mDataReference,String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();
        gettingData.getSportData(sport_name,"male","live",listScore,scoresAdapter,mDataReference);

        gettingData.getSportData(sport_name,"female","live",listScore,scoresAdapter,mDataReference);


    }


    public static void getLiveMatches(List<MaleSportResultListData> listScore, MaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();
        gettingData.getSportData(sport_name,"male","live",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));



    }

    public static void getFutureMatches(List<MaleSportResultListData> listScore, MaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();
        gettingData.getSportData(sport_name,"male","future",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));
    }


    public static void getPastMatches(List<MaleSportResultListData> listScore, MaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();
        gettingData.getSportData(sport_name,"male","past",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));
    }



    public static void getLiveMatches(List<FemaleSportResultListData> listScore, FemaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();

        gettingData.getSportData(sport_name,"female","live",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));


    }

    public static void getFutureMatches(List<FemaleSportResultListData> listScore, FemaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();

        gettingData.getSportData(sport_name,"female","future",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));


    }

    public static void getPastMatches(List<FemaleSportResultListData> listScore, FemaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, String sport_name){
        getDataFromFirebase gettingData=new getDataFromFirebase();

        gettingData.getSportData(sport_name,"female","past",listScore,scoresAdapter,mDataReference,Constants.backgroundForSport.get(sport_name));


    }



    public static  void setPrefForScore(List list){
        Log.d(TAG, "randomShit: I am Genius"+ list.toString());
    }

    public static void addStatusToList(List<MaleSportResultListData> list,MaleSportResultListRecyclerAdapter scoresAdapter)
    {
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Past")) {
                list.remove(i);
                i--;
            }}for(int i=0;i<list.size();i++){
        if(list.get(i).get_when().equals("past")) {
            list.add(i,new MaleSportResultListData(Constants.StatusViewTypeCode,"Past","","","","","","","","","","","","","","","",0,0));
            break;
        }}

        //list.remove(new MaleSportResultListData(Constants.StatusViewTypeCode,"Live","","","","","","","","","","","","","",0));
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Live")) {
                list.remove(i);
                i--;
            }}
        int j=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_when().equals("live")) {
                list.add(i,new MaleSportResultListData(Constants.StatusViewTypeCode,"Live","","","","","","","","","","","","","","","",0,-100000));
                j=i;
                break;
            }}

        MaleResults.contextMaleRes.scrollTo(j,0);


        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Upcoming")) {
                list.remove(i);
                i--;
            }}for(int i=0;i<list.size();i++){
            if(list.get(i).get_when().equals("future")) {
                list.add(i,new MaleSportResultListData(Constants.StatusViewTypeCode,"Upcoming","","","","","","","","","","","","","","","",0,200000));
                break;
            }}

        Collections.sort(list, new Comparator<MaleSportResultListData>() {
            @Override
            public int compare(MaleSportResultListData u1, MaleSportResultListData u2) {
                return u1.getStartTime()-(u2.getStartTime());
            }
        });
        scoresAdapter.notifyDataSetChanged();

    }

    public static void addStatusToList(List<FemaleSportResultListData> list,FemaleSportResultListRecyclerAdapter scoresAdapter)
    {
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Past")) {
                list.remove(i);
                i--;
            }}for(int i=0;i<list.size();i++){
        if(list.get(i).get_when().equals("past")) {
            list.add(i,new FemaleSportResultListData(Constants.StatusViewTypeCode,"Past","","","","","","","","","","","","","","","",0,0));
            break;
        }}

        //list.remove(new MaleSportResultListData(Constants.StatusViewTypeCode,"Live","","","","","","","","","","","","","",0));
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Live")) {
                list.remove(i);
                i--;
            }}
        int j=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).get_when().equals("live")) {
                list.add(i,new FemaleSportResultListData(Constants.StatusViewTypeCode,"Live","","","","","","","","","","","","","","","",0,-100000));
                j=i;
                break;
            }}

        FemaleResults.contextFemaleRes.scrollTo(j,0);


        for(int i=0;i<list.size();i++){
            if(list.get(i).get_eventName().equals("Upcoming")) {
                list.remove(i);
                i--;
            }}for(int i=0;i<list.size();i++){
        if(list.get(i).get_when().equals("future")) {
            list.add(i,new FemaleSportResultListData(Constants.StatusViewTypeCode,"Upcoming","","","","","","","","","","","","","","","",0,200000));
            break;
        }}

        Collections.sort(list, new Comparator<FemaleSportResultListData>() {
            @Override
            public int compare(FemaleSportResultListData u1, FemaleSportResultListData u2) {
                return u1.getStartTime()-(u2.getStartTime());
            }
        });
        scoresAdapter.notifyDataSetChanged();
    }

    public static int getTimeFromDate(String date,String time,String when){

        int ans=0;

        if(when.equals("live"))
            ans-=100000;
        if(when.equals("future"))
            ans+=200000;

        if(date.equals("") || time.equals(""))
            return ans;
        Log.d(TAG, "getTimeFromDate: "+date);
        try {
            ans += Integer.parseInt(date.substring(0, date.indexOf("/"))) * 1440;
            ans += 60 * Integer.parseInt(time.substring(0, time.indexOf(":")));
            ans += Integer.parseInt(time.substring(time.indexOf(":") + 1));
        }catch (Exception e){
            ans+=1;
        }

        return ans;

    }

}
