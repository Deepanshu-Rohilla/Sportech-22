package com.sportech20.iitd;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

public class sportsListRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView sportName;
    FoldingCell fc;
    ImageView sport_icon;
    ImageView sport_icon2;
    TextView sportName2;
    TextView seeMore;

    TextView team1_name, team2_name, team1_score, team2_score, venue, type;

    public sportsListRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        sportName = itemView.findViewById(R.id.sport_name);
        sportName2 = itemView.findViewById(R.id.sport_name2);

        fc=itemView.findViewById(R.id.folding_cell);
        sport_icon=itemView.findViewById(R.id.sport_icon);
        sport_icon2=itemView.findViewById(R.id.sport_icon2);

        seeMore=itemView.findViewById(R.id.seeAllResults);

        team1_name = itemView.findViewById(R.id.team1);
        team2_name = itemView.findViewById(R.id.team2);
        team1_score = itemView.findViewById(R.id.team1_score);
        team2_score = itemView.findViewById(R.id.team2_score);
        venue = itemView.findViewById(R.id.venue);
        type = itemView.findViewById(R.id.type);

    }
}
