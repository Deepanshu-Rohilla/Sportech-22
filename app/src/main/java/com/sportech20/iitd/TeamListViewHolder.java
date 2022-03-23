package com.sportech20.iitd;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TeamListViewHolder extends RecyclerView.ViewHolder {

    TextView membName,membPost,membContact;
    FloatingActionButton membFacebook,membLinkedIn,membEmail,membInsta;
    ImageView membPhoto;

    public TeamListViewHolder(@NonNull View itemView) {
        super(itemView);
        membName=itemView.findViewById(R.id.memberName);
        membPost=itemView.findViewById(R.id.memberPost);
        membContact=itemView.findViewById(R.id.memberContact);

        membFacebook=itemView.findViewById(R.id.membFacebook);
        membLinkedIn=itemView.findViewById(R.id.membLinkedIn);
       // membEmail=itemView.findViewById(R.id.membEmail);
        membPhoto=itemView.findViewById(R.id.membPhoto);
        membInsta=itemView.findViewById(R.id.membInsta);
}
}
