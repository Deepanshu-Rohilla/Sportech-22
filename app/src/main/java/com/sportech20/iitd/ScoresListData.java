
package com.sportech20.iitd;


import androidx.appcompat.app.AppCompatActivity;

public class ScoresListData {
    String team1, team2, team3, team1_score, team2_score, team3_score, venue, type, setScore, event_name, extra_info_left, extra_info_right, sportName;

    public ScoresListData(String event_name,String team1, String team2, String team3, String team1_score,
                   String team2_score, String team3_score, String venue, String type, String setScore,String extra_info_left,String extra_info_right)
    {
        this.extra_info_left=extra_info_left;
        this.extra_info_right=extra_info_right;
        this.team3=team3;
        this.team3_score=team3_score;
        this.event_name=event_name;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.venue = venue;
        this.type = type;
        this.setScore = setScore;

    }


    public String get_team1_name() {
        return this.team1;
    }

    public String get_extra_info_left() {
        return this.extra_info_left;
    }

    public String get_extra_info_right() {
        return this.extra_info_right;
    }

    public String get_venue() {
        return this.venue;
    }

    public void set_team1_score(String s) {
        this.team1_score = s;
    }
    public void set_team3_score(String s) {
        this.team3_score = s;
    }
    public String get_team3_name() {
        return this.team3;
    }



    public void setTeam3(String s){this.team3=s;}
    public void setExtra_info_left(String s){this.extra_info_left=s;}

    public void setExtra_info_right(String s){this.extra_info_right=s;}

    public void set_team2_score(String s) {
        this.team2_score = s;
    }

    public void set_setScore(String s) {
        this.setScore = s;
    }
    public void set_event_name(String s) {
        this.event_name = s;
    }

    public void set_type(String s) {
        this.type = s;
    }}

