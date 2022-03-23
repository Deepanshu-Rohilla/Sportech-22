package com.sportech20.iitd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ScoresListRecyclerAdapter extends RecyclerView.Adapter<ScoresListViewHolder> {

    List<ScoresListData> list
            = Collections.emptyList();

    Context context;

    public ScoresListRecyclerAdapter(List<ScoresListData> list,
                                     Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public ScoresListViewHolder
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

        ScoresListViewHolder viewHolder
                = new ScoresListViewHolder(photoView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ScoresListViewHolder viewHolder, final int position) {
        viewHolder.venue.setText(list.get(position).venue);
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


        viewHolder.mType.setText(list.get(position).type);
        viewHolder.mSetScore.setText(list.get(position).setScore);
        viewHolder.event_name.setText(list.get(position).event_name);
                viewHolder.linearLayout.post(new Runnable(){
            public void run(){
                int height = viewHolder.linearLayout.getHeight();
                viewHolder.cardView.setMinimumHeight(height);
                Log.d(TAG, "run: Come on "+height);
            }
        });

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
