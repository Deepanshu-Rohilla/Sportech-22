package com.sportech20.iitd.map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.internal.service.Common;
import com.sportech20.iitd.CampusMap;
import com.sportech20.iitd.CommonFunctions;
import com.sportech20.iitd.R;

import java.util.List;

public class mapPointRecyclerViewAdapter extends RecyclerView.Adapter<mapPointRecyclerViewAdapter.ViewHolder> {

    private List<mapPointData> list;
    public Context context;

    public mapPointRecyclerViewAdapter(List<mapPointData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_point_layout, parent, false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mName.setText(list.get(position).getName());
        holder.mPoint.setText(list.get(position).getPoint());
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Sa", "892");
            }
        });

        holder.googleLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CommonFunctions.openURL(list.get(position).locationURL,context);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mPoint;
        public LinearLayout ll;
        ImageView googleLoc;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.nameLocation);
            mPoint = itemView.findViewById(R.id.gridNumber);
            ll = itemView.findViewById(R.id.map_point_ll);
            googleLoc=itemView.findViewById(R.id.googleLoc);
        }
    }


}
