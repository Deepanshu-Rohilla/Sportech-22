package com.sportech20.iitd;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static String[] allSportsname={"Athletics","Badminton","Basketball","Chess","Cricket","Football","Hockey","Squash","Tabletennis","Lawntennis","Volleyball","Weightlifting"};
    public static String[] unisexSports={"Chess","Cricket","Weightlifting",allSportsname[5],allSportsname[6]};
    public static final int RacquetViewTypeCode=1;
    public static final int NormalViewTypeCode=0;
    public static final int StatusViewTypeCode=2;

    public static final int TeamOCType=0;
    public static final int TeamTechType=1;

    public static final String[] TechMembFacebook={"https://www.facebook.com/","https://m.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/"};
    public static final String[] TechMembLinkedin={"https://www.linkedin.com/in/deepanshu-rohilla-418940188/","https://www.linkedin.com/in/pranjal2041/","https://www.linkedin.com/in/siddhesh-kalekar-310311201/","https://www.linkedin.com/in/sayam-sethi-4930751a0/","https://www.linkedin.com/in/asharam-meena/"};
    public static final String[] TechMembInsta={"https://www.instagram.com/deepanshu__rohilla/","https://www.instagram.com/pranjalaggarwal2041/","https://www.instagram.com/siddhesh_.k/","https://www.instagram.com/sayam.sethi2/","https://www.instagram.com/uchiha_asha/"};
    public static final String[] TechMembEmail={"","","","",""};

    public static final String[] TechMembNames={"Deepanshu Rohilla",
    "Pranjal Aggarwal","Siddhesh","Sayam Sethi","Asharam Meena"};

    public static final String[] TechMembContact={"","","","",""};

    public static final int[] TechMembPhoto={ R.drawable.deepanshu,
    R.drawable.pranjal,R.drawable.siddhesh, R.drawable.sayam,R.drawable.asharam};

    public static final String[] TechMembPost={"Overall Coordinator (Technical)",
            "App-Development Coordinator",
            "App-Development Coordinator",
    "App-Development Coordinator",
            "App-Development Coordinator"};

    public static final String[] OCMembNames={
            "Harsh Pratap Singh",
            "Chand Delvadiya",
            "Mihir Okte",

            "Deepanshu Rohilla",
            "Ananya Choudhary",
            "Sarang Dev",

            "Tanmay Gupta",
            "Himaadri Nagarkoti",
            "Himanshu Kumawat",

            "Yateek",
            "Shubham Singh Rathore",
            "Shantanu Meena"};

    public static final String[] OCMembContact={"",
            "",
            "",

            "",
            "",
            "",

            "",
            "",
            "",

            "",
            "",
            ""};

    public static final String[] OCMembPost={
            "General Secretary, BSA IIT Delhi",
            "BSA Council",
            "Overall Coordinator",

            "Overall Coordinator",
            "Overall Coordinator",
            "Overall Coordinator",

            "Overall Coordinator",
            "Overall Coordinator",
            "Overall Coordinator",

            "Overall Coordinator",
            "Overall Coordinator","Overall Coordinator"};

    public static final String[] OCMembEmail={
            "",
            "",
            "",

            "",
            "",
            "",

            "",
            "",
            "",

            "",
            "",
            ""};

    public static final String[] OCMembFacebook={"https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/",
            "https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/","https://www.facebook.com/"};

    public static final String[] OCMembInsta={"https://www.instagram.com/_harsh25/","https://www.instagram.com/moon_it_is_/","https://www.instagram.com/mihirokte/","https://www.instagram.com/deepanshu__rohilla/","https://www.instagram.com/","https://www.instagram.com/sdev3112/","https://www.instagram.com/tanmaygupta_918/","https://www.instagram.com/nagar___da/","https://www.instagram.com/hk_00_7/","https://www.instagram.com/the_swooping_evil/","https://www.instagram.com/oliver.shubham/","https://www.instagram.com/__.shantanuu.__/"};
    public static final String[] OCMembLinkedin={"https://www.linkedin.com/in/harsh-pratap-singh-8701ab17a/",
            "https://www.linkedin.com/in/chand-delvadiya-7820971a8/",
    "https://www.linkedin.com/in/mihirokte/","https://www.linkedin.com/in/deepanshu-rohilla-418940188/","https://www.linkedin.com/in/ananya-choudhary-3a8953188/",
            "https://www.linkedin.com/in/sarang-dev-b825a21ba/","https://www.linkedin.com/in/tanmay-gupta-69669b1b2/","https://www.linkedin.com/in/himaadri-nagarkoti-9415a1218/",
            "https://www.linkedin.com/in/himanshu-kumawat-115b27209/","https://www.linkedin.com/in/yateek-singh-6a5706202/",
            "",""};

    public static final int[] OCMembPhoto={R.drawable.harsh_pratap,R.drawable.chand,R.drawable.mihir,
    R.drawable.deepanshu,R.drawable.ananya_choudhary,R.drawable.sarang,R.drawable.tanmay,R.drawable.himadri,R.drawable.himanshu,
            R.drawable.yateek, R.drawable.contact, R.drawable.shantanu};

    public static Map<String, Integer> backgroundForSport = new HashMap<String, Integer>() {{


        put(allSportsname[0],R.mipmap.athy_back_foreground);
        put(allSportsname[1],R.drawable.baddy_results_back);
        put(allSportsname[2],R.mipmap.basketball_back_foreground);
        put(allSportsname[3],R.mipmap.chess_back_foreground);
        put(allSportsname[4],R.drawable.cricket_results_back);
        put(allSportsname[5],R.mipmap.football_back_foreground);
        put(allSportsname[6],R.mipmap.hockey_back_foreground);
        put(allSportsname[7],R.mipmap.squash_back_foreground);
        put(allSportsname[8],R.mipmap.tt_back_foreground);
        put(allSportsname[9],R.mipmap.tennis_back_foreground);
        put(allSportsname[10],R.mipmap.volly_back_foreground);
        put(allSportsname[11],R.mipmap.weightlifting_back_foreground);
        //etc
    }};

    /*public static Dictionary<String, Integer> backgroundForSport = new Hashtable<>();
    Constants(){
        backgroundForSport.put(allSportsname[0],R.mipmap.athy_back);
        backgroundForSport.put(allSportsname[1],R.color.colorWhite);
        backgroundForSport.put(allSportsname[2],R.mipmap.basketball_back);
        backgroundForSport.put(allSportsname[3],R.mipmap.chess_back);
        backgroundForSport.put(allSportsname[4],R.color.colorWhite);
        backgroundForSport.put(allSportsname[5],R.mipmap.football_back);
        backgroundForSport.put(allSportsname[6],R.mipmap.hockey_back);
        backgroundForSport.put(allSportsname[7],R.mipmap.squash_back);
        backgroundForSport.put(allSportsname[8],R.mipmap.tt_back);
        backgroundForSport.put(allSportsname[9],R.mipmap.tennis_back);
        backgroundForSport.put(allSportsname[10],R.mipmap.volly_back);
        backgroundForSport.put(allSportsname[11],R.mipmap.weightlifting_back);


    }*/

}
