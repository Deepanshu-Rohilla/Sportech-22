package com.sportech20.iitd;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SportsListRecyclerAdapter
        extends RecyclerView.Adapter<sportsListRecyclerViewHolder> {

    List<sportsListData> list
            = Collections.emptyList();

    Context context;

    public SportsListRecyclerAdapter(List<sportsListData> list,
                                Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public sportsListRecyclerViewHolder
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
                .inflate(R.layout.sports_foldview,
                        parent, false);

        sportsListRecyclerViewHolder viewHolder
                = new sportsListRecyclerViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final sportsListRecyclerViewHolder viewHolder, final int position) {

        viewHolder.sportName
                .setText(list.get(position).sportName);
        viewHolder.sportName2
                .setText(list.get(position).sportName);
        viewHolder.team1_score.setText(list.get(position).team1_score);
        viewHolder.team2_score.setText(list.get(position).team2_score);
        viewHolder.team1_name.setText(list.get(position).team1_name);
        viewHolder.team2_name.setText(list.get(position).team2_name);
        viewHolder.venue.setText(list.get(position).venue);
        viewHolder.type.setText(list.get(position).type);

        viewHolder.fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.fc.toggle(false);

            }
        });

        viewHolder.sport_icon.setImageDrawable(list.get(position).drawable);
        viewHolder.sport_icon2.setImageDrawable(list.get(position).drawable);

       viewHolder.seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SportResults.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("Sport", list.get(position).sportName);
                context.startActivity(intent);
            }
        });


        // set custom parameters
// or with camera height parameter
        //viewHolder.fc.initialize(0, 1000, Color.DKGRAY,0);


     /*   viewHolder.image_gallery_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "OOh Yeah", Toast.LENGTH_SHORT).show();
            }
        });*/
        /*viewHolder.examDate
                .setText(list.get(position).date);
        viewHolder.examMessage
                .setText(list.get(position).message);*/
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
/*
    // Sample data for RecyclerView
    private List<sportsListData> getData()
    {
        List<sportsListData> list = new ArrayList<>();
        list.add(new sportsListData("First Exam",
                "May 23, 2015",
                "Best Of Luck"));
        list.add(new sportsListData("Second Exam",
                "June 09, 2015",
                "b of l"));
        list.add(new sportsListData("My Test Exam",
                "April 27, 2017",
                "This is testing exam .."));

        return list;
    }*/
}

