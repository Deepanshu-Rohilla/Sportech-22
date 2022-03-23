package com.sportech20.iitd.com.sportech20.iitd.sportResult;


public class MaleSportResultListData{

    public static final int Raquet_Type=0;
    public static final int Normal_Type=1;
    int startTime;
    String team1, team2, team3, team4, team1_score, team2_score, team3_score, team4_score,venue, type, setScore,event_name,extra_info_left,extra_info_right;
    String setDetails,currentTitle;
    public int sport_type,background;
    int viewType;
    String when;
    public MaleSportResultListData(int viewType,String event_name,String team1, String team2, String team3,String team4, String team1_score,
                          String team2_score, String team3_score,String team4_score, String venue, String type, String setScore,String setDetails,String extra_info_left,String extra_info_right,String currentTitle,int background,int startTime)
    {
        when="";
        this.background=background;
        this.currentTitle=currentTitle;
        this.setDetails=setDetails;
        this.viewType=viewType;
        this.extra_info_left=extra_info_left;
        this.extra_info_right=extra_info_right;
        this.team3=team3;
        this.team3_score=team3_score;
        this.team4=team4;
        this.team4_score=team4_score;
        this.event_name=event_name;
        this.team1 = team1;
        this.team2 = team2;
        this.team1_score = team1_score;
        this.team2_score = team2_score;
        this.venue = venue;
        this.type = type;
        this.setScore = setScore;
        this.startTime=startTime;
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
    public void set_team4_score(String s) {
        this.team4_score = s;
    }

    public String get_team3_name() {
        return this.team3;
    }



    public void setTeam3(String s){this.team3=s;}
    public void setTeam4(String s){this.team4=s;}

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
    }

    public void set_when(String when){
        this.when=when;}
        public String get_when(){
        return when;
        }
        public String get_eventName(){
            return event_name;
        }

        public void set_setDetails(String a){
            setDetails=a;
     }
     public void setCurrentTitle(String a){
        currentTitle=a;
     }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
