package com.sportech20.iitd.sponsors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.CommonFunctions;
import com.sportech20.iitd.R;

import java.util.List;

public class sponsorsAdapter extends RecyclerView.Adapter<sportViewHolder> {

    private Context mContext;
    private List<sponsorsData> list;

    public sponsorsAdapter(Context context, List<sponsorsData> list) {
        this.mContext = context;
        this.list = list;
    }


    @Override
    public sportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.indiv_sponsor_company, parent, false);
        return new sportViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(sportViewHolder holder, final int position) {
        holder.photo.setImageResource(list.get(position).photo);
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonFunctions.openURL(list.get(position).url,mContext);
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
}

class sportViewHolder extends RecyclerView.ViewHolder {
    sportViewHolder(View itemView) {
        super(itemView);
    }

    ImageView photo = itemView.findViewById(R.id.sponsor_image);
}
