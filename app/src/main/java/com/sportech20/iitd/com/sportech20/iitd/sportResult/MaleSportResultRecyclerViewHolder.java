package com.sportech20.iitd.com.sportech20.iitd.sportResult;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.R;

public class MaleSportResultRecyclerViewHolder extends RecyclerView.ViewHolder{


        TextView currentTitle,extra_info_left_tv,extra_info_right_tv,venue, team1_name, team2_name,team3_name,team4_name, mTeam1_score, mTeam2_score, mTeam3_score,mTeam4_score, mType, mSetScore,event_name,raq_event_name;
        CardView cardView;
        LinearLayout linearLayout;
        ImageButton go_to_venue;
        ConstraintLayout cl;
        View status;
        TextView tv_status;


        TextView racquet_team1_name;
        TextView racquet_team2_name;
        TextView racquet_team1_score;
        TextView racquet_team2_score;
        TextView setDetails;
        TextView racquet_sport_result;

        View normal_sport_view;
        View racquet_sport_view;


        public MaleSportResultRecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                cl=itemView.findViewById(R.id.extra_info_cl);
                extra_info_left_tv=itemView.findViewById(R.id.extra_info_left);
                extra_info_right_tv=itemView.findViewById(R.id.extra_info_right);
                team3_name=itemView.findViewById(R.id.team3);
                mTeam3_score=itemView.findViewById(R.id.team3_score);
                team4_name=itemView.findViewById(R.id.team4);
                mTeam4_score=itemView.findViewById(R.id.team4_score);
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

                normal_sport_view=itemView.findViewById(R.id.normal_sport_layout);
                racquet_sport_view=itemView.findViewById(R.id.racquet_sport_layout);
                racquet_team1_name=itemView.findViewById(R.id.team1_name);
                racquet_team2_name=itemView.findViewById(R.id.team2_name);
                racquet_team1_score=itemView.findViewById(R.id.set1Team1_score);
                racquet_team2_score=itemView.findViewById(R.id.set1Team2_score);
                setDetails=itemView.findViewById(R.id.setDetails);
                currentTitle=itemView.findViewById(R.id.racquet_current_title);
                racquet_sport_result=itemView.findViewById(R.id.racquet_sport_result);
                status=itemView.findViewById(R.id.live_status);
                tv_status=itemView.findViewById(R.id.text_live_status);
                raq_event_name=itemView.findViewById(R.id.raq_event_name);
        }
}