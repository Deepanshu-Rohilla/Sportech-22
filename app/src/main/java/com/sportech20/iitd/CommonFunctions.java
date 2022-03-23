package com.sportech20.iitd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class CommonFunctions {

    public static boolean openURL(String url, Context context)
    {

        try {


            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;

        }catch (Exception e){
            return false;
        }

    }
}
