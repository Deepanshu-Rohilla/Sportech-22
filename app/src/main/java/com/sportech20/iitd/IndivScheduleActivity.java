package com.sportech20.iitd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.Random;

public class IndivScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indiv_schedule);
        final ImageView imageView=findViewById(R.id.indiv_schedule_iv);
        Intent intent=getIntent();
        String sport_name = intent.getStringExtra("Sport");
        int image=0;
        assert sport_name != null;
        switch (sport_name){
            case "CRICKET":
                image=R.drawable.cricket;
                break;
            case "ATHLETICS":
                image=R.drawable.athy_schedule;
                break;
            case "FOOTBALL":
                image=R.drawable.footy_final;
                break;
            case "WEIGHTLIFTING":
                image=R.drawable.weightlifting_schedule;
                break;
        }

        //imageView.setImage(ImageSource.resource(image));
        imageView.setImageResource(image);

    }
}
