package com.sportech20.iitd;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ScoresListViewHolder extends RecyclerView.ViewHolder {

    TextView extra_info_left_tv,extra_info_right_tv,venue, team1_name, team2_name,team3_name, mTeam1_score, mTeam2_score, mTeam3_score, mType, mSetScore,event_name;
    CardView cardView;
    LinearLayout linearLayout;
    ImageButton go_to_venue;
    ConstraintLayout cl;

    public ScoresListViewHolder(@NonNull View itemView) {

        super(itemView);
        cl=itemView.findViewById(R.id.extra_info_cl);
        extra_info_left_tv=itemView.findViewById(R.id.extra_info_left);
        extra_info_right_tv=itemView.findViewById(R.id.extra_info_right);
        team3_name=itemView.findViewById(R.id.team3);
        mTeam3_score=itemView.findViewById(R.id.team3_score);
        event_name=itemView.findViewById(R.id.event_name);
        //venue = itemView.findViewById(R.id.venue_home);
        team1_name = itemView.findViewById(R.id.team1);
        team2_name = itemView.findViewById(R.id.team2);
        mTeam1_score = itemView.findViewById(R.id.team1_score);
        mTeam2_score = itemView.findViewById(R.id.team2_score);
        //go_to_venue = itemView.findViewById(R.id.goToVenue);
        mType = itemView.findViewById(R.id.type);
        mSetScore = itemView.findViewById(R.id.setScore);
        cardView=itemView.findViewById(R.id.score_card_cv);
        linearLayout=itemView.findViewById(R.id.score_card_ll);
    }
}
