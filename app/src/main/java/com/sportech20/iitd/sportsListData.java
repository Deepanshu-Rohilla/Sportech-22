package com.sportech20.iitd;

import android.graphics.drawable.Drawable;

public class sportsListData {

    String sportName, team1_name, team2_name, team1_score, team2_score, type, venue;
    Drawable drawable;


    public sportsListData(String name, Drawable drawable, String team1_name, String team2_name,
                    String team1_score, String team2_score, String type, String venue)
    {
        this.sportName = name;
        this.drawable=drawable;
        this.team1_name = team1_name;
        this.team2_name = team2_name;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.type = type;
        this.venue = venue;
    }

    public String get_sport_name() {
        return this.sportName;
    }

    public void set_team1_name(String s) {
        this.team1_name = s;
    }

    public void set_team2_name(String s) {
        this.team2_name = s;
    }

    public void set_team1_score(String s) {
        this.team1_score = s;
    }

    public void set_team2_score(String s) {
        this.team2_score = s;
    }

    public void set_venue(String s) {
        this.venue = s;
    }

    public void set_type(String s) {
        this.type = type;
    }

}
