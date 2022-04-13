package com.sportech20.iitd.newSportFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sportech20.iitd.CommonFunctions;
import com.sportech20.iitd.Constants;
import com.sportech20.iitd.IndivScheduleActivity;
import com.sportech20.iitd.R;
import com.sportech20.iitd.SportResults;

import java.util.List;

public class newSportFragAdapter extends RecyclerView.Adapter<sportViewHolder> {

    private Context mContext;
    private List<sportFragData> sportList;

    public newSportFragAdapter(Context context, List<sportFragData> sportList) {
        this.mContext = context;
        this.sportList = sportList;
    }


    @Override
    public sportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_sport_frag_item_row, parent, false);
        return new sportViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(sportViewHolder holder, final int position) {
        holder.mSportIcon.setImageResource(sportList.get(position).getSportIcon());
        holder.mSportName.setText(sportList.get(position).getSportName());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sportList.get(position).getSportName().equals(Constants.allSportsname[4])){
                    try {
                        if (sportList.get(position).isUseInSchedule()) {
                            String t= (String) sportList.get(position).getSportName();
                            if(!(t.equals("CRICKET") ||t.equals("FOOTBALL") ||t.equals("WEIGHTLIFTING") ||t.equals("ATHLETICS")))
                            {
                                Toast.makeText(mContext, "To be announced soon", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            //Toast.makeText(context, "Opening "+dataSet.get(listPosition).getSport()+" Schedule", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(mContext, IndivScheduleActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            intent.putExtra("Sport", t);
                            mContext.startActivity(intent);
                        }
                        else {
                            Toast.makeText(mContext, "Opening CricHeroes for live scores", Toast.LENGTH_SHORT).show();
                            Uri uri = Uri.parse("https://cricheroes.in/tournament/113333/Sportech-IIT-Delhi#team");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }


                    }catch (Exception e){
                        Toast.makeText(mContext, "Unable to open CricHeros", Toast.LENGTH_SHORT).show();
                    }                }
                else {
                    if (sportList.get(position).isUseInSchedule()) {
                        String t= (String) sportList.get(position).getSportName();
                        if(!(t.equals("CRICKET") ||t.equals("FOOTBALL") ||t.equals("WEIGHTLIFTING") ||t.equals("ATHLETICS")))
                        {
                            Toast.makeText(mContext, "To be announced soon", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //Toast.makeText(context, "Opening "+dataSet.get(listPosition).getSport()+" Schedule", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(mContext, IndivScheduleActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        intent.putExtra("Sport", t);
                        mContext.startActivity(intent);
                    }
                    else {
                        Toast.makeText(mContext, "Loading..", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(mContext, SportResults.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        intent.putExtra("Sport", sportList.get(position).getSportName());
                        mContext.startActivity(intent);
                    }

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return sportList.size();
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

    ImageView mSportIcon = itemView.findViewById(R.id.sportsLogo);
    TextView mSportName = itemView.findViewById(R.id.sportName);
    CardView mCardView = itemView.findViewById(R.id.sportFragCardView);
}
