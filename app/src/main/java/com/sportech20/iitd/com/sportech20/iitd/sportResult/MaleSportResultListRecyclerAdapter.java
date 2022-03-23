package com.sportech20.iitd.com.sportech20.iitd.sportResult;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.Constants;
import com.sportech20.iitd.R;

import java.util.Collections;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MaleSportResultListRecyclerAdapter extends RecyclerView.Adapter<MaleSportResultRecyclerViewHolder> {

    List<MaleSportResultListData> list
            = Collections.emptyList();

    Context context;

    public MaleSportResultListRecyclerAdapter(List<MaleSportResultListData> list,
                                     Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public MaleSportResultRecyclerViewHolder
    onCreateViewHolder(ViewGroup parent,
                       int viewType)
    {



        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.score_card,
                        parent, false);

        MaleSportResultRecyclerViewHolder viewHolder
                = new MaleSportResultRecyclerViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MaleSportResultRecyclerViewHolder viewHolder, final int position) {
        viewHolder.racquet_sport_view.setVisibility(View.GONE);
        viewHolder.normal_sport_view.setVisibility(View.GONE);
        viewHolder.status.setVisibility(View.GONE);

        // viewHolder.linearLayout.setBackgroundResource(list.get(position).background);

        switch (list.get(position).viewType) {
            case Constants.StatusViewTypeCode:
                if(!list.get(position).event_name.equals("Live") && !list.get(position).event_name.equals("Past")){
                    viewHolder.cardView.setVisibility(View.GONE);
                    break;
                }
                viewHolder.status.setVisibility(View.VISIBLE);
                viewHolder.tv_status.setText(list.get(position).event_name);
                viewHolder.linearLayout.post(new Runnable(){
                    public void run(){
                        int height = viewHolder.linearLayout.getHeight();
                        viewHolder.cardView.setMinimumHeight(height);
                        Log.d(TAG, "run: Come on "+height);
                    }
                });
                break;

            case Constants.NormalViewTypeCode:
                viewHolder.normal_sport_view.setVisibility(View.VISIBLE);
//                viewHolder.venue.setText(list.get(position).venue);
                viewHolder.team1_name.setText(list.get(position).team1);
                viewHolder.team2_name.setText(list.get(position).team2);
                viewHolder.mTeam1_score.setText(list.get(position).team1_score);
                viewHolder.mTeam2_score.setText(list.get(position).team2_score);
                if(list.get(position).team3_score.equals("")){
                    viewHolder.mTeam3_score.setVisibility(View.GONE);
                }
                else {
                    viewHolder.mTeam3_score.setVisibility(View.VISIBLE);
                    viewHolder.mTeam3_score.setText(list.get(position).team3_score);
                }
                if(list.get(position).team3.equals("")){
                    viewHolder.team3_name.setVisibility(View.GONE);
                }
                else {
                    viewHolder.team3_name.setVisibility(View.VISIBLE);
                    viewHolder.team3_name.setText(list.get(position).team3);
                }
                if(list.get(position).team4_score.equals("")){
                    viewHolder.mTeam4_score.setVisibility(View.GONE);
                }
                else {
                    viewHolder.mTeam4_score.setVisibility(View.VISIBLE);
                    viewHolder.mTeam4_score.setText(list.get(position).team4_score);
                }
                if(list.get(position).team4.equals("")){
                    viewHolder.team4_name.setVisibility(View.GONE);
                }
                else {
                    viewHolder.team4_name.setVisibility(View.VISIBLE);
                    viewHolder.team4_name.setText(list.get(position).team4);
                }
                if(list.get(position).extra_info_left.equals("")){
                    viewHolder.extra_info_left_tv.setVisibility(View.GONE);
                }
                else {
                    viewHolder.extra_info_left_tv.setVisibility(View.VISIBLE);
                    viewHolder.extra_info_left_tv.setText(list.get(position).extra_info_left);
                }
                if(list.get(position).extra_info_right.equals("")){
                    viewHolder.extra_info_right_tv.setVisibility(View.GONE);
                }
                else {
                    viewHolder.extra_info_right_tv.setVisibility(View.VISIBLE);
                    viewHolder.extra_info_right_tv.setText(list.get(position).extra_info_right);
                }


                if(list.get(position).type.equals("")){
                    viewHolder.mType.setVisibility(View.GONE);
                }
                else {
                    viewHolder.mType.setVisibility(View.VISIBLE);
                    viewHolder.mType.setText(list.get(position).type);
                }

                viewHolder.mSetScore.setText(list.get(position).setScore);
                viewHolder.event_name.setText(list.get(position).event_name);
                viewHolder.linearLayout.post(new Runnable(){
                    public void run(){
                        int height = viewHolder.linearLayout.getHeight();
                        viewHolder.cardView.setMinimumHeight(height);
                        Log.d(TAG, "run: Come on "+height);
                    }
                });
                break;
            case Constants.RacquetViewTypeCode:
               // viewHolder.venue.setText(list.get(position).venue);
                viewHolder.racquet_sport_view.setVisibility(View.VISIBLE);
                viewHolder.racquet_team1_name.setText(list.get(position).team1);
                viewHolder.racquet_team2_name.setText(list.get(position).team2);
                viewHolder.racquet_team1_score.setText(list.get(position).team1_score);
                viewHolder.racquet_team2_score.setText(list.get(position).team2_score);
                viewHolder.setDetails.setText(list.get(position).setDetails);
                viewHolder.raq_event_name.setText(list.get(position).event_name);
                viewHolder.currentTitle.setText(list.get(position).currentTitle);
                if(list.get(position).type.equals("")){
                    viewHolder.racquet_sport_result.setVisibility(View.GONE);
                }
                else {
                    viewHolder.racquet_sport_result.setVisibility(View.VISIBLE);
                    viewHolder.racquet_sport_result.setText(list.get(position).type);
                }
                viewHolder.linearLayout.post(new Runnable(){
                    public void run(){
                        int height = viewHolder.linearLayout.getHeight();
                        viewHolder.cardView.setMinimumHeight(height);
                        Log.d(TAG, "run: Come on "+height);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}


