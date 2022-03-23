package com.sportech20.iitd;

import android.content.Context;
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

public class PhotoslistRecyclerAdapter
        extends RecyclerView.Adapter<PhotosListRecyclerViewHolder> {

    List<PhotosListData> list
            = Collections.emptyList();

    Context context;

    public PhotoslistRecyclerAdapter(List<PhotosListData> list,
                                     Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public PhotosListRecyclerViewHolder
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
                .inflate(R.layout.gallery_highlights,
                        parent, false);

        PhotosListRecyclerViewHolder viewHolder
                = new PhotosListRecyclerViewHolder(photoView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PhotosListRecyclerViewHolder viewHolder, final int position) {
        viewHolder.description.setText(list.get(position).desc);
        viewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).liked=!list.get(position).liked;
                if(list.get(position).liked)
                    viewHolder.like.setImageResource(R.drawable.ic_favorite_pink_24px);
                else
                    viewHolder.like.setImageResource(R.drawable.ic_favorite_24px);
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

