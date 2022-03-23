package com.sportech20.iitd.map;

public class mapPointData {

    String locationName, locationPoint,locationURL;

    public mapPointData(String locationName, String locationPoint) {
        this.locationName = locationName;
        this.locationPoint = locationPoint;
    }


    public mapPointData(String locationName, String locationPoint,String locationURL) {
        this.locationName = locationName;
        this.locationPoint = locationPoint;
        this.locationURL=locationURL;
    }

    public String getName() {
        return locationName;
    }

    public String getPoint() {
        return locationPoint;
    }

    public void setName(String s) {
        this.locationName = s;
    }

    public void setPoint(String s) {
        this.locationName = s;
    }
}
