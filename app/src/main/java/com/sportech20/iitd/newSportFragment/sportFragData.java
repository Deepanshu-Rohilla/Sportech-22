package com.sportech20.iitd.newSportFragment;

public class sportFragData {

    private String sportName;
    private int sportIcon;

    public sportFragData(String sportName, int sportIcon) {
        this.sportName = sportName;
        this.sportIcon = sportIcon;
    }

    public String getSportName() {
        return sportName;
    }

    public int getSportIcon() {
        return sportIcon;
    }

}
