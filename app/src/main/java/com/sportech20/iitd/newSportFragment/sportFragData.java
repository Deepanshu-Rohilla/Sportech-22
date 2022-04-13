package com.sportech20.iitd.newSportFragment;

public class sportFragData {

    private String sportName;
    private int sportIcon;
    private boolean useInSchedule;

    public sportFragData(String sportName,
                         int sportIcon,
                         boolean useInSchedule) {
        this.sportName = sportName;
        this.sportIcon = sportIcon;
        this.useInSchedule = useInSchedule;
    }

    public String getSportName() {
        return sportName;
    }

    public int getSportIcon() {
        return sportIcon;
    }

    public boolean isUseInSchedule() {
        return useInSchedule;
    }
}
