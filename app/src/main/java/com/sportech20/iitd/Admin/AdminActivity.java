package com.sportech20.iitd.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.sportech20.iitd.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AdminActivity extends AppCompatActivity {
    Button addMatch;
    TextView sportName;
    EditText matchName;
    Spinner spinner,spinner2;
    String header;
    Class className;
    String gender = "male";
    Long matchCount;
    ValueEventListener valueEventListener;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_admin);

        addMatch = findViewById(R.id.addMatch);
        sportName = findViewById(R.id.sportName);
        matchName = findViewById(R.id.addMatchName);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final String admin_id = FirebaseAuth.getInstance().getUid();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String matchID = "match1";
                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.child(header).child(gender).child("match").getChildren();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("Select a match");
                for (DataSnapshot match: dataSnapshots) {
                    arrayList.add(match.child("eventName").getValue(String.class));
                    matchID = match.getKey();
                }
                matchCount = Long.parseLong(matchID.substring(5)) + 1;
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, arrayList);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(Arrays.asList("male", "female")));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);



        if (admin_id == null) {
            throw new NullPointerException("Error in login");
        }
        else if (admin_id.equals(getResources().getString(R.string.chessUID))) {
                header = "Chess";
                className = AdminRacketSpecial.class;
                spinner2.setSelection(0);
                spinner2.setVisibility(View.GONE);
        }
        else if (admin_id.equals(getResources().getString(R.string.athleticsUID))) {
            header = "Athletics";
            className = AthleticsAdmin.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.badmintonUID))) {
            header = "Badminton";
            className = AdminRacketSpecial.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.basketballUID))) {
            header = "Basketball";
            className = AdminNonRacketMatch.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.cricketUID))) {
            header = "Cricket";
            className = AdminNonRacketMatch.class;
            spinner2.setSelection(0);
            spinner2.setVisibility(View.GONE);
        }
        else if (admin_id.equals(getResources().getString(R.string.footballUID))) {
            header = "Football";
            className = AdminNonRacketMatch.class;
            spinner2.setSelection(0);
            spinner2.setVisibility(View.GONE);
        }
        else if (admin_id.equals(getResources().getString(R.string.hockeyUID))) {
            header = "Hockey";
            className = AdminNonRacketMatch.class;
            spinner2.setSelection(0);
            spinner2.setVisibility(View.GONE);
        }
        else if (admin_id.equals(getResources().getString(R.string.lawntennisUID))) {
            header = "Lawntennis";
            className = AdminRacketSpecial.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.squashUID))) {
            header = "Squash";
            className = AdminRacketSpecial.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.tabletennisUID))) {
            header = "Tabletennis";
            className = AdminRacketSpecial.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.volleyballUID))) {
            header = "Volleyball";
            className = AdminRacketSpecial.class;
        }
        else if (admin_id.equals(getResources().getString(R.string.weightliftingUID))) {
            header = "Weightlifting";
            className = AdminRacketSpecial.class;
            spinner2.setSelection(0);
            spinner2.setVisibility(View.GONE);
        }

        sportName.setText(header.toUpperCase());
        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = matchName.getText().toString();
                if (eventName.isEmpty()){
                    matchName.setError("Enter match name!");
                    matchName.requestFocus();
                }

                else {
                    matchName.setText("");
                    Intent intent = new Intent(AdminActivity.this, className);
                    intent.putExtra("matchName",
                            "match" + matchCount);
                    intent.putExtra("gender", gender);
                    intent.putExtra("header", header);
                    intent.putExtra("new", true);
                    intent.putExtra("eventName", eventName);
                    startActivity(intent);
                }
            }
        });
        mDatabase.addValueEventListener(valueEventListener);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(0);
                final String eventName = spinner.getAdapter().getItem(position).toString();
                Query query = mDatabase.child(header).child(spinner2.getSelectedItem()
                        .toString()).child("match");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
                        for (DataSnapshot match: dataSnapshots) {
                            if (match.child("eventName").getValue(String.class).equals(eventName))
                            {
                                Intent intent = new Intent(AdminActivity.this,
                                        className);
                                intent.putExtra("matchName", match.getKey());
                                intent.putExtra("header", header);
                                intent.putExtra("gender", gender);
                                intent.putExtra("eventName",eventName);
                                startActivity(intent);
                                return;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = spinner2.getAdapter().getItem(position).toString();
                mDatabase.addListenerForSingleValueEvent(valueEventListener);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(AdminActivity.this, "Please select gender!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mDatabase.addListenerForSingleValueEvent(valueEventListener);
    }
}
