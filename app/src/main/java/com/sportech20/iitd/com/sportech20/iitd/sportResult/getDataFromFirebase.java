package com.sportech20.iitd.com.sportech20.iitd.sportResult;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.sportech20.iitd.Constants;
import com.sportech20.iitd.FirebaseDataHandler.GetScoresData;
import com.sportech20.iitd.HomeFrag;
import com.sportech20.iitd.R;
import com.sportech20.iitd.ScoresListData;
import com.sportech20.iitd.ScoresListRecyclerAdapter;
import com.sportech20.iitd.SportsListRecyclerAdapter;
import com.sportech20.iitd.sportsListData;

import java.util.Iterator;
import java.util.List;

public class getDataFromFirebase extends AppCompatActivity {

    // public DatabaseReference mDataReference;


    public void getSportData(String sportName, String gender, final String when,
                             final List<ScoresListData> list, final ScoresListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference) {
        mDataReference.child(sportName).child(gender).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    if (item.getKey().charAt(0) == 'm') {
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = item.child("team1").getValue().toString();
                            String team2 = item.child("team2").getValue().toString();
                            String team1_score = item.child("team1_score").getValue().toString();
                            String team2_score = item.child("team2_score").getValue().toString();

                            String venue = item.child("venue").getValue().toString();
                            String type = item.child("type").getValue().toString().toUpperCase();
                            String setScore = "";
                            String event_name="";
                            String team3_score="";
                            String team3="";
                            String extra_info_left="";
                            String extra_info_right="";
                            if(item.hasChild("team3_score")){
                                team3_score = item.child("team3_score").getValue().toString();

                            }
                            if(item.hasChild("team3")){
                                team3 = item.child("team3").getValue().toString();
                            }
                            if(item.hasChild("extra_info_left")){
                                extra_info_left = item.child("extra_info_left").getValue().toString();

                            }
                            if(item.hasChild("extra_info_right")){
                                extra_info_right = item.child("extra_info_right").getValue().toString();
                            }
                            if (item.hasChild("setscore")) {
                                setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }
                            if (item.hasChild("eventName")) {
                                event_name = item.child("eventName").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }
                            list.add(new ScoresListData(event_name,team1, team2,team3, team1_score, team2_score,team3_score, venue, type, setScore,extra_info_left,extra_info_right));
                            GetScoresData.setPrefForScore(list);
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }
                    else if(item.getKey().charAt(0)=='n'){
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = "1st:- "+item.child("winner").getValue().toString();
                            String team2 ="2nd:- " +item.child("runner_up").getValue().toString();
                            String team1_score ="";//= item.child("team1_score").getValue().toString();
                            String team2_score = "";//item.child("team2_score").getValue().toString();
                            String venue ="Athletics Ground";// item.child("venue").getValue().toString();
                            String type = "3rd:-  "+item.child("runner_up2").getValue().toString().toUpperCase();
                            String event_name = item.child("eventName").getValue().toString();



                            String team3_score="";
                            String team3="";
                            if(item.hasChild("team3_score")){
                                team3_score = item.child("team3_score").getValue().toString();

                            }
                            if(item.hasChild("team3")){
                                team3 = item.child("team3").getValue().toString();
                            }
                            String extra_info_left="";
                            String extra_info_right="";
                            if(item.hasChild("extra_info_left")){
                                extra_info_left = item.child("extra_info_left").getValue().toString();

                            }
                            if(item.hasChild("extra_info_right")){
                                extra_info_right = item.child("extra_info_right").getValue().toString();
                            }
                            String setScore = "";
                            if (item.hasChild("setscore")) {
                                setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }

                            list.add(new ScoresListData(event_name,team1, team2,team3, team1_score, team2_score,team3_score, venue, type, setScore,extra_info_left,extra_info_right));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    if (item.getKey().charAt(0) == 'm') {
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = item.child("team1").getValue().toString();
                            String team2 = item.child("team2").getValue().toString();
                            String team1_score = item.child("team1_score").getValue().toString();
                            String team2_score = item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            //String event_name = item.child("eventName").getValue().toString();

                            // String type = item.child("type").getValue().toString().toUpperCase();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                }
                            }
                            // list.add(new ScoresListData(team1, team2, team1_score, team2_score, venue, type));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }else if(item.getKey().charAt(0)=='n'){
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = "1st:- "+item.child("winner").getValue().toString();
                            String team2 ="2nd:- " +item.child("runner_up").getValue().toString();
                            String team1_score ="";//= item.child("team1_score").getValue().toString();
                            String team2_score = "";//item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            String type = "";//"Bronze:-  "+item.child("runner_up2").getValue().toString().toUpperCase();
                            String event_name = item.child("eventName").getValue().toString();

                            String setScore = "";
                            if (item.hasChild("setscore")) {
                                setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }

                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    list.get(i).set_event_name(event_name);
                                    list.get(i).set_type(type);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                }
                            }
                          //  list.add(new ScoresListData(event_name,team1, team2, team1_score, team2_score, venue, type, setScore));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    String[] getChildAddData(DataSnapshot item,String when,String sport_name)
    {
        if (item.getKey().charAt(0) == 'm' && !(sport_name.equals(Constants.allSportsname[0]))) {
            if (item.child("when").getValue().toString().equals(when)) {
                String team1 = item.child("team1").getValue().toString();
                String team2 = item.child("team2").getValue().toString();
                String team1_score = item.child("team1_score").getValue().toString();
                String team2_score = item.child("team2_score").getValue().toString();

                String venue = item.child("venue").getValue().toString();
                String type = item.child("type").getValue().toString().toUpperCase();
                String setScore = "";
                String event_name="";
                String team3_score="";
                String team3="";
                String team4_score="";
                String team4="";
                String extra_info_left="";
                String extra_info_right="";
                String setDetails="";
                String date="1/1/2020";
                String time="1:1";
                int sportType=Constants.NormalViewTypeCode;

                String currentTitle="";
                if(item.hasChild("currentTitle")){
                    currentTitle = item.child("currentTitle").getValue().toString();
                }


                if(item.hasChild("date")){
                    date = item.child("date").getValue().toString();
                }
                if(item.hasChild("time")){
                    time = item.child("time").getValue().toString();
                }
                int timeInSec=GetScoresData.getTimeFromDate(date,time,when);

                if(item.hasChild("setDetails")){
                    setDetails = item.child("setDetails").getValue().toString();
                }
                if(item.hasChild("team3_score")){
                    team3_score = item.child("team3_score").getValue().toString();
                }
                if(item.hasChild("team4_score")){
                    team4_score = item.child("team4_score").getValue().toString();
                }
                if(item.hasChild("sport_type")){
                    sportType = Integer.parseInt(item.child("sport_type").getValue().toString());

                }
                if(item.hasChild("team3")){
                    team3 = item.child("team3").getValue().toString();
                }
                if(item.hasChild("team4")){
                    team4 = item.child("team4").getValue().toString();
                }
                if(item.hasChild("extra_info_left")){
                    extra_info_left = item.child("extra_info_left").getValue().toString();

                }
                if(item.hasChild("extra_info_right")){
                    extra_info_right = item.child("extra_info_right").getValue().toString();
                }
                if (item.hasChild("setscore")) {
                    setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                }
                if (item.hasChild("eventName")) {
                    event_name = item.child("eventName").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                }
                String[] arr={sportType+"",event_name,team1, team2,team3,team4, team1_score, team2_score,team3_score,team4_score, venue, type, setScore,setDetails,extra_info_left,extra_info_right,currentTitle,""+timeInSec};
                return arr;
            }
        }
        else if(item.getKey().charAt(0)=='m' && sport_name.equals(Constants.allSportsname[0])){
//            Toast.makeText(this, "atleast sport is correct", Toast.LENGTH_SHORT).show();
            if (item.child("when").getValue().toString().equals(when)) {
                String team1 = "1st:- "+item.child("winner").getValue().toString();
                String team2 ="2nd:- " +item.child("runner_up").getValue().toString();
                String team1_score ="";//= item.child("team1_score").getValue().toString();
                String team2_score = "";//item.child("team2_score").getValue().toString();
                String venue ="Athletics Ground";// item.child("venue").getValue().toString();
                String team3 = "3rd:-  "+item.child("runner_up2").getValue().toString().toUpperCase();
                String team4 = "4th:-  "+item.child("runner_up3").getValue().toString().toUpperCase();

                String event_name = item.child("eventName").getValue().toString();


                String type="";
                String team3_score="";
                String team4_score="";

                if(item.hasChild("team3_score")){
                    team3_score = item.child("team3_score").getValue().toString();
                }
                if(item.hasChild("team4_score")){
                    team4_score = item.child("team4_score").getValue().toString();
                }
                if(item.hasChild("team1_score")){
                    team1_score = item.child("team1_score").getValue().toString();
                }

                if(item.hasChild("team2_score")){
                    team2_score = item.child("team2_score").getValue().toString();
                }

                String date="1/1/2020";
                String time="1:1";
                if(item.hasChild("date")){
                    date = item.child("date").getValue().toString();
                }
                if(item.hasChild("time")){
                    time = item.child("time").getValue().toString();
                }
                int timeInSec=GetScoresData.getTimeFromDate(date,time,when);

                String extra_info_left="";
                String extra_info_right="";
                String currentTitle="";
                if(item.hasChild("currentTitle")){
                    currentTitle = item.child("currentTitle").getValue().toString();
                }
                if(item.hasChild("extra_info_left")){
                    extra_info_left = item.child("extra_info_left").getValue().toString();
                }
                if(item.hasChild("extra_info_right")){
                    extra_info_right = item.child("extra_info_right").getValue().toString();
                }
                String setScore = "";
                if (item.hasChild("setscore")) {
                    setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                }

                String[] arr={"0",event_name,team1, team2,team3,team4, team1_score, team2_score,team3_score,team4_score, venue, type, setScore,"",extra_info_left,extra_info_right,currentTitle,""+timeInSec};
                return arr;

            }
        }
        return null;
    }

    public void getSportData(final String sportName, String gender, final String when,
                             final List<MaleSportResultListData> list, final MaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, final int background) {
        mDataReference.child(sportName).child(gender).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();

                    String[] temp=getChildAddData(item,when,sportName);
                    if(temp!=null){
                    MaleSportResultListData xyz=new MaleSportResultListData(Integer.parseInt(temp[0]),temp[1],temp[2], temp[3],temp[4],temp[5], temp[6], temp[7],temp[8],temp[9], temp[10], temp[11], temp[12],temp[13],temp[14],temp[15],temp[16],background,Integer.parseInt(temp[17]));
                    xyz.set_when(when);
                    list.add(xyz);
                    scoresAdapter.notifyDataSetChanged();}

                }
                GetScoresData.addStatusToList(list,scoresAdapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();

                    if(item.hasChild("team1")) {
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = item.child("team1").getValue().toString();
                            String team2 = item.child("team2").getValue().toString();
                            String team1_score = item.child("team1_score").getValue().toString();
                            String team2_score = item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            //String event_name = item.child("eventName").getValue().toString();

                            // String type = item.child("type").getValue().toString().toUpperCase();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }
                                    if (item.hasChild("team4_score")) {
                                        list.get(i).set_team4_score(item.child("team4_score").getValue().toString());
                                    }
                                    if (item.hasChild("team4")) {
                                        list.get(i).setTeam4(item.child("team4").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("currentTitle")) {
                                        list.get(i).setCurrentTitle(item.child("currentTitle").getValue().toString());
                                    }
                                    if (item.hasChild("type")) {
                                        list.get(i).set_type(item.child("type").getValue().toString());
                                    }
                                    if (item.hasChild("setDetails")) {
                                        list.get(i).set_setDetails(item.child("setDetails").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                }
                            }
                            // list.add(new ScoresListData(team1, team2, team1_score, team2_score, venue, type));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }else if(item.hasChild("winner")){
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = "1st:- "+item.child("winner").getValue().toString();
                            String team2 ="2nd:- " +item.child("runner_up").getValue().toString();
                            String team1_score ="";//= item.child("team1_score").getValue().toString();
                            String team2_score = "";//item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            String type = "";//"Bronze:-  "+item.child("runner_up2").getValue().toString().toUpperCase();
                            String event_name = item.child("eventName").getValue().toString();

                            String setScore = "";
                            if (item.hasChild("setscore")) {
                                setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }

                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    list.get(i).set_event_name(event_name);
                                    list.get(i).set_type(type);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team4_score")) {
                                        list.get(i).set_team4_score(item.child("team4_score").getValue().toString());
                                    }
                                    if (item.hasChild("team2_score")) {
                                        list.get(i).set_team2_score(item.child("team2_score").getValue().toString());
                                    }
                                    if (item.hasChild("team1_score")) {
                                        list.get(i).set_team1_score(item.child("team1_score").getValue().toString());
                                    }

                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }
                                    if (item.hasChild("team4")) {
                                        list.get(i).setTeam4(item.child("team4").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                    if (item.hasChild("type")) {
                                        list.get(i).set_type(item.child("type").getValue().toString());
                                    }
                                }
                            }
                            //  list.add(new ScoresListData(event_name,team1, team2, team1_score, team2_score, venue, type, setScore));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }
                }
                GetScoresData.addStatusToList(list,scoresAdapter);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void getSportData(final String sportName, String gender, final String when,
                             final List<FemaleSportResultListData> list, final FemaleSportResultListRecyclerAdapter scoresAdapter, DatabaseReference mDataReference, final int background) {
        mDataReference.child(sportName).child(gender).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    String[] temp=getChildAddData(item,when,sportName);
                    if(temp!=null){
                        FemaleSportResultListData xyz=new FemaleSportResultListData(Integer.parseInt(temp[0]),temp[1],temp[2], temp[3],temp[4],temp[5], temp[6], temp[7],temp[8],temp[9], temp[10], temp[11], temp[12],temp[13],temp[14],temp[15],temp[16],background,Integer.parseInt(temp[17]));
                        xyz.set_when(when);
                        list.add(xyz);
                        scoresAdapter.notifyDataSetChanged();}
                    GetScoresData.addStatusToList(list, scoresAdapter);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext()) {
                    DataSnapshot item = items.next();
                    if (item.getKey().charAt(0) == 'm') {
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = item.child("team1").getValue().toString();
                            String team2 = item.child("team2").getValue().toString();
                            String team1_score = item.child("team1_score").getValue().toString();
                            String team2_score = item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            //String event_name = item.child("eventName").getValue().toString();

                            // String type = item.child("type").getValue().toString().toUpperCase();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }
                                    if (item.hasChild("team4_score")) {
                                        list.get(i).set_team4_score(item.child("team4_score").getValue().toString());
                                    }
                                    if (item.hasChild("team4")) {
                                        list.get(i).setTeam4(item.child("team4").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("currentTitle")) {
                                        list.get(i).setCurrentTitle(item.child("currentTitle").getValue().toString());
                                    }
                                    if (item.hasChild("type")) {
                                        list.get(i).set_type(item.child("type").getValue().toString());
                                    }
                                    if (item.hasChild("setDetails")) {
                                        list.get(i).set_setDetails(item.child("setDetails").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                }
                            }
                            // list.add(new ScoresListData(team1, team2, team1_score, team2_score, venue, type));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }else if(item.getKey().charAt(0)=='n'){
                        if (item.child("when").getValue().toString().equals(when)) {
                            String team1 = "1st:- "+item.child("winner").getValue().toString();
                            String team2 ="2nd:- " +item.child("runner_up").getValue().toString();
                            String team1_score ="";//= item.child("team1_score").getValue().toString();
                            String team2_score = "";//item.child("team2_score").getValue().toString();
                            String venue = item.child("venue").getValue().toString();
                            String type = "";//"Bronze:-  "+item.child("runner_up2").getValue().toString().toUpperCase();
                            String event_name = item.child("eventName").getValue().toString();

                            String setScore = "";
                            if (item.hasChild("setscore")) {
                                setScore = item.child("setscore").getValue().toString();
                             /*   TextView set;
                                set = findViewById(R.id.setScore);
                                set.setVisibility(View.GONE);*/
                            }

                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).get_team1_name().equals(team1)
                                        && list.get(i).get_venue().equals(venue)) {
                                    list.get(i).set_team1_score(team1_score);
                                    list.get(i).set_team2_score(team2_score);
                                    list.get(i).set_event_name(event_name);
                                    list.get(i).set_type(type);
                                    if (item.hasChild("setscore")) {
                                        list.get(i).set_setScore(item.child("setscore").getValue().toString());
                                    }
                                    if (item.hasChild("eventName")) {
                                        list.get(i).set_event_name(item.child("eventName").getValue().toString());
                                    }
                                    if (item.hasChild("team3_score")) {
                                        list.get(i).set_team3_score(item.child("team3_score").getValue().toString());
                                    }
                                    if (item.hasChild("team4_score")) {
                                        list.get(i).set_team4_score(item.child("team4_score").getValue().toString());
                                    }
                                    if (item.hasChild("team2_score")) {
                                        list.get(i).set_team2_score(item.child("team2_score").getValue().toString());
                                    }
                                    if (item.hasChild("team1_score")) {
                                        list.get(i).set_team1_score(item.child("team1_score").getValue().toString());
                                    }

                                    if (item.hasChild("team3")) {
                                        list.get(i).setTeam3(item.child("team3").getValue().toString());
                                    }
                                    if (item.hasChild("team4")) {
                                        list.get(i).setTeam4(item.child("team4").getValue().toString());
                                    }

                                    if (item.hasChild("extra_info_right")) {
                                        list.get(i).setExtra_info_right(item.child("extra_info_right").getValue().toString());
                                    }
                                    if (item.hasChild("extra_info_left")) {
                                        list.get(i).setExtra_info_left(item.child("extra_info_left").getValue().toString());
                                    }
                                    if (item.hasChild("type")) {
                                        list.get(i).set_type(item.child("type").getValue().toString());
                                    }
                                }
                            }
                            //  list.add(new ScoresListData(event_name,team1, team2, team1_score, team2_score, venue, type, setScore));
                            scoresAdapter.notifyDataSetChanged();
                        }
                    }
                }
                GetScoresData.addStatusToList(list,scoresAdapter);

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
