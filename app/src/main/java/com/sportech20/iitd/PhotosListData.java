package com.sportech20.iitd;

import android.graphics.drawable.Drawable;

public class PhotosListData {
    int likes;
    Drawable drawable;
    String desc;
    boolean liked;

    PhotosListData(String desc,
                   Drawable drawable,int likes)
    {
        this.drawable=drawable;
        this.desc=desc;
        this.likes=likes;
        liked=false;
    }
}

