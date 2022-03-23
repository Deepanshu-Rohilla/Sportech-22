package com.sportech20.iitd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    Context context;
    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        context=parent.getContext();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        final TextView textView = holder.textView;

        textView.setText(dataSet.get(listPosition).getSport());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t= (String) textView.getText();
                if(!(t.equals("CRICKET") ||t.equals("FOOTBALL") ||t.equals("WEIGHTLIFTING") ||t.equals("ATHLETICS")))
                {
                    Toast.makeText(context, "To be announced soon", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(context, "Opening "+dataSet.get(listPosition).getSport()+" Schedule", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, IndivScheduleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("Sport", textView.getText());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView1);
        }
    }
}

