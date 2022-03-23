package com.sportech20.iitd;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class PhotosListRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView num_likes;
    ImageButton like;
    ImageButton share;
    ImageView image;
    TextView description;

    public PhotosListRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        num_likes=itemView.findViewById(R.id.num_like);
        like=itemView.findViewById(R.id.image_gallery_like);
        share=itemView.findViewById(R.id.image_gallery_share);
        image=itemView.findViewById(R.id.image_photo_highlight);
        description=itemView.findViewById(R.id.sport_description);
}
}
