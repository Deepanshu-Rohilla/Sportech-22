package com.sportech20.iitd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.com.sportech20.iitd.sportResult.FemaleSportResultListData;

import java.util.Collections;
import java.util.List;

public class TeamlistRecyclerAdapter
        extends RecyclerView.Adapter<TeamListViewHolder> {

    List<TeamListData> list
            = Collections.emptyList();

    Context context;

    public TeamlistRecyclerAdapter(List<TeamListData> list,
                                   Context context)
    {
        this.list = list;
        this.context = context;
    }

    @Override
    public TeamListViewHolder
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
                .inflate(R.layout.team_details_layout,
                        parent, false);

        TeamListViewHolder viewHolder
                = new TeamListViewHolder(photoView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TeamListViewHolder viewHolder, final int position) {
        viewHolder.membName.setText(list.get(position).MembName);
        viewHolder.membPhoto.setImageResource(list.get(position).MembPhoto);
        viewHolder.membContact.setText(list.get(position).MembContact);
        viewHolder.membPost.setText(list.get(position).MembPost);
        viewHolder.membFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonFunctions.openURL(list.get(position).MembFaceURL,context);

            }
        });
        viewHolder.membLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonFunctions.openURL(list.get(position).MembLinkURL,context);

            }
        });
        /*viewHolder.membEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Message via Sportech|IITD");
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{list.get(position).MembEmail});
                emailIntent.setType("message/rfc822");




                try {
                    TeamMembers.context1.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                }


            }
        });*/
        if(!list.get(position).MembInsta.equals("")) {
            viewHolder.membInsta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CommonFunctions.openURL(list.get(position).MembInsta, context);
                }
            });
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

