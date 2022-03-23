package com.sportech20.iitd.Admin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sportech20.iitd.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;


public class AdminRacketSpecial extends AppCompatActivity {
    ProgressBar updateProgress;
    Button update;
    static Button date, time;
    static Boolean newM;
    public int prevPosition;
    EditText eventName, team1Name, team2Name, team3Name, set1Team1, set1Team2, set2Team1, set2Team2;
    EditText set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2;
    EditText set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1;
    EditText set10Team2, set11Team1, set11Team2, set12Team1, set12Team2, set13Team1, set13Team2;
    EditText set14Team1, set14Team2, set15Team1, set15Team2, venue, result, additionalInfo, type;
    TextView set1Name, set1Type, set2Name, set2Type, set3Name, set3Type, set4Name, set4Type;
    TextView set5Name, set5Type, set6Name, set6Type, set7Name, set7Type, set8Name, set8Type;
    TextView set9Name, set9Type, set10Name, set10Type, set11Name, set11Type, set12Name, set12Type;
    TextView set13Name, set13Type, set14Name, set14Type, set15Name, set15Type, set, setName, currentName;
    Spinner status, currentSpinner, currentSetSpinner;
    LinearLayout set12, set13, set14, set15, current, resultLL, additionalInfoLL, typeLL, team3LL;
    DatabaseReference databaseReference;
    LinearLayout set1, set2, set3, set4, set5, set6, set7, set8, set9, set10, set11, currentSetLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String header = getIntent().getStringExtra("header");
        final String matchName = getIntent().getStringExtra("matchName");
        final String gender = getIntent().getStringExtra("gender");
        final String eventNameVal = getIntent().getStringExtra("eventName");
        newM = getIntent().getBooleanExtra("new", false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_racket_special);

        updateProgress = findViewById(R.id.updateProgress);
        update = findViewById(R.id.update);
        status = findViewById(R.id.status);
        eventName = findViewById(R.id.eventName);
        team1Name = findViewById(R.id.team1Name);
        team2Name = findViewById(R.id.team2Name);
        team3Name = findViewById(R.id.team3Name);
        current = findViewById(R.id.current);
        set1Team1 = findViewById(R.id.set1Team1);
        set1Team2 = findViewById(R.id.set1Team2);
        set2Team1 = findViewById(R.id.set2Team1);
        set2Team2 = findViewById(R.id.set2Team2);
        set3Team1 = findViewById(R.id.set3Team1);
        set3Team2 = findViewById(R.id.set3Team2);
        set4Team1 = findViewById(R.id.set4Team1);
        set4Team2 = findViewById(R.id.set4Team2);
        set5Team1 = findViewById(R.id.set5Team1);
        set5Team2 = findViewById(R.id.set5Team2);
        set6Team1 = findViewById(R.id.set6Team1);
        set6Team2 = findViewById(R.id.set6Team2);
        set7Team1 = findViewById(R.id.set7Team1);
        set7Team2 = findViewById(R.id.set7Team2);
        set8Team1 = findViewById(R.id.set8Team1);
        set8Team2 = findViewById(R.id.set8Team2);
        set9Team1 = findViewById(R.id.set9Team1);
        set9Team2 = findViewById(R.id.set9Team2);
        set10Team1 = findViewById(R.id.set10Team1);
        set10Team2 = findViewById(R.id.set10Team2);
        set11Team1 = findViewById(R.id.set11Team1);
        set11Team2 = findViewById(R.id.set11Team2);
        set12Team1 = findViewById(R.id.set12Team1);
        set12Team2 = findViewById(R.id.set12Team2);
        set13Team1 = findViewById(R.id.set13Team1);
        set13Team2 = findViewById(R.id.set13Team2);
        set14Team1 = findViewById(R.id.set14Team1);
        set14Team2 = findViewById(R.id.set14Team2);
        set15Team1 = findViewById(R.id.set15Team1);
        set15Team2 = findViewById(R.id.set15Team2);
        venue = findViewById(R.id.venue);
        result = findViewById(R.id.result);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        additionalInfo = findViewById(R.id.additionalInfo);
        type = findViewById(R.id.type);
        set1Name = findViewById(R.id.set1Name);
        set1Type = findViewById(R.id.set1Type);
        set2Name = findViewById(R.id.set2Name);
        set2Type = findViewById(R.id.set2Type);
        set3Name = findViewById(R.id.set3Name);
        set3Type = findViewById(R.id.set3Type);
        set4Name = findViewById(R.id.set4Name);
        set4Type = findViewById(R.id.set4Type);
        set5Name = findViewById(R.id.set5Name);
        set5Type = findViewById(R.id.set5Type);
        set6Name = findViewById(R.id.set6Name);
        set6Type = findViewById(R.id.set6Type);
        set7Name = findViewById(R.id.set7Name);
        set7Type = findViewById(R.id.set7Type);
        set8Name = findViewById(R.id.set8Name);
        set8Type = findViewById(R.id.set8Type);
        set9Name = findViewById(R.id.set9Name);
        set9Type = findViewById(R.id.set9Type);
        set10Name = findViewById(R.id.set10Name);
        set10Type = findViewById(R.id.set10Type);
        set11Name = findViewById(R.id.set11Name);
        set11Type = findViewById(R.id.set11Type);
        set12Name = findViewById(R.id.set12Name);
        set12Type = findViewById(R.id.set12Type);
        set13Name = findViewById(R.id.set13Name);
        set13Type = findViewById(R.id.set13Type);
        set14Name = findViewById(R.id.set14Name);
        set14Type = findViewById(R.id.set14Type);
        set15Name = findViewById(R.id.set15Name);
        set15Type = findViewById(R.id.set15Type);
        set1 = findViewById(R.id.set1);
        set2 = findViewById(R.id.set2);
        set3 = findViewById(R.id.set3);
        set4 = findViewById(R.id.set4);
        set5 = findViewById(R.id.set5);
        set6 = findViewById(R.id.set6);
        set7 = findViewById(R.id.set7);
        set8 = findViewById(R.id.set8);
        set9 = findViewById(R.id.set9);
        set10 = findViewById(R.id.set10);
        set11 = findViewById(R.id.set11);
        set12 = findViewById(R.id.set12);
        set13 = findViewById(R.id.set13);
        set14 = findViewById(R.id.set14);
        set15 = findViewById(R.id.set15);
        set = findViewById(R.id.set);
        setName = findViewById(R.id.setName);
        currentSpinner = findViewById(R.id.currentSpinner);
        currentSetLL = findViewById(R.id.currentSetLL);
        currentSetSpinner = findViewById(R.id.currentSetSpinner);
        resultLL = findViewById(R.id.resultLL);
        additionalInfoLL = findViewById(R.id.additionalInfoLL);
        team3LL = findViewById(R.id.team3LL);
        typeLL = findViewById(R.id.typeLL);
        currentName = findViewById(R.id.currentName);
        prevPosition = 0;
        final TextView[] setNames = new TextView[]{set1Name, set2Name, set3Name, set4Name, set5Name, set6Name, set7Name, set8Name, set9Name, set10Name, set11Name, set12Name, set13Name, set14Name, set15Name};
        final ArrayList<String> setList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child(header).
                child(gender).child("match").child(matchName);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AdminRacketSpecial.TimePickerFragment().show(getSupportFragmentManager(), "timePicker");
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AdminRacketSpecial.DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
            }
        });

        updateProgress.setVisibility(View.GONE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(Arrays.asList("LIVE", "PAST")));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapter);

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, setList);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currentSetSpinner.setAdapter(adapter1);

        switch (header) {
            case "Weightlifting":
                set4.setVisibility(View.GONE);
                set5.setVisibility(View.GONE);
                set6.setVisibility(View.GONE);
                set7.setVisibility(View.GONE);
                set8.setVisibility(View.GONE);
                set9.setVisibility(View.GONE);
                set10.setVisibility(View.GONE);
                set11.setVisibility(View.GONE);
                set12.setVisibility(View.GONE);
                set13.setVisibility(View.GONE);
                set14.setVisibility(View.GONE);
                set15.setVisibility(View.GONE);
                currentSetLL.setVisibility(View.GONE);
                current.setVisibility(View.GONE);
                resultLL.setVisibility(View.GONE);
                additionalInfoLL.setVisibility(View.GONE);
                set.setText("Team");
                setName.setText("Total");
                set1Team1.setHint("Clean/Jerk");
                set1Team2.setHint("Snatch");
                set2Team1.setHint("Clean/Jerk");
                set2Team2.setHint("Snatch");
                set3Team1.setHint("Clean/Jerk");
                set3Team2.setHint("Snatch");
                if (newM) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("date", "Select Date");
                    hashMap.put("time", "Select Time");
                    hashMap.put("eventName", eventNameVal);
                    hashMap.put("extra_info_right", "Clean    Snatch  Total\nJerk");
                    hashMap.put("team1", team1Name.getText().toString());
                    hashMap.put("team1_score", "0" + "   " + "0" + "   " + "0");
                    hashMap.put("team2", team2Name.getText().toString());
                    hashMap.put("team2_score", "0" + "   " + "0" + "   " + "0");
                    hashMap.put("team3", team3Name.getText().toString());
                    hashMap.put("team3_score", "0" + "   " + "0" + "   " + "0");
                    hashMap.put("type", type.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                    databaseReference.setValue(hashMap);
                }
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String[] team1Score, team2Score, team3Score;
                        String currentStatus;
                        eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                        team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                        team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                        team3Name.setText(dataSnapshot.child("team3").getValue().toString());
                        team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                split("\\s+");
                        team3Score = dataSnapshot.child("team3_score").getValue().toString().
                                split("\\s+");
                        set1Team1.setText(team1Score[0]);
                        set1Team2.setText(team1Score[1]);
                        set1Type.setText(team1Score[2]);
                        set2Team1.setText(team2Score[0]);
                        set2Team2.setText(team2Score[1]);
                        set2Type.setText(team2Score[2]);
                        set3Team1.setText(team3Score[0]);
                        set3Team2.setText(team3Score[1]);
                        set3Type.setText(team3Score[2]);
                        venue.setText(dataSnapshot.child("venue").getValue().toString());
                        date.setText(dataSnapshot.child("date").getValue().toString());
                        time.setText(dataSnapshot.child("time").getValue().toString());
                        type.setText(dataSnapshot.child("type").getValue().toString());
                        currentStatus = dataSnapshot.child("when").getValue().toString();
                        if (currentStatus.equals("live")) {
                            status.setSelection(0);
                        } else if (currentStatus.equals("past")) {
                            status.setSelection(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                        if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                            Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                        } else {
                            updateProgress.setVisibility(View.VISIBLE);
                            set1Type.setText(String.valueOf(Integer.parseInt(set1Team1.getText().toString())
                                    + Integer.parseInt(set1Team2.getText().toString())));
                            set2Type.setText(String.valueOf(Integer.parseInt(set2Team1.getText().toString())
                                    + Integer.parseInt(set2Team2.getText().toString())));
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("date", date.getText().toString());
                            hashMap.put("time", time.getText().toString());
                            hashMap.put("eventName", eventName.getText().toString());
                            hashMap.put("extra_info_right", "Clean    Snatch  Total\nJerk");
                            hashMap.put("team1", team1Name.getText().toString());
                            hashMap.put("team1_score", set1Team1.getText().toString() + "        " +
                                    set1Team2.getText().toString() + "      " +
                                    set1Type.getText().toString());
                            hashMap.put("team2", team2Name.getText().toString());
                            hashMap.put("team2_score", set2Team1.getText().toString() + "        " +
                                    set2Team2.getText().toString() + "      " +
                                    set2Type.getText().toString());
                            hashMap.put("team3", team3Name.getText().toString());
                            hashMap.put("team3_score", set3Team1.getText().toString() + "        " +
                                    set3Team2.getText().toString() + "      " +
                                    set3Type.getText().toString());
                            hashMap.put("type", type.getText().toString());
                            hashMap.put("venue", venue.getText().toString());
                            hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    updateProgress.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please retry",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
                        }
                    }
                });
                break;
            case "Volleyball":
                team3LL.setVisibility(View.GONE);
                set6.setVisibility(View.GONE);
                set7.setVisibility(View.GONE);
                set8.setVisibility(View.GONE);
                set9.setVisibility(View.GONE);
                set10.setVisibility(View.GONE);
                set11.setVisibility(View.GONE);
                set12.setVisibility(View.GONE);
                set13.setVisibility(View.GONE);
                set14.setVisibility(View.GONE);
                set15.setVisibility(View.GONE);
                current.setVisibility(View.GONE);
                set1Type.setVisibility(View.GONE);
                set2Type.setVisibility(View.GONE);
                set3Type.setVisibility(View.GONE);
                set4Type.setVisibility(View.GONE);
                set5Type.setVisibility(View.GONE);
                set6Type.setVisibility(View.GONE);
                set7Type.setVisibility(View.GONE);
                set8Type.setVisibility(View.GONE);
                set9Type.setVisibility(View.GONE);
                set10Type.setVisibility(View.GONE);
                set11Type.setVisibility(View.GONE);
                set12Type.setVisibility(View.GONE);
                set13Type.setVisibility(View.GONE);
                set14Type.setVisibility(View.GONE);
                set15Type.setVisibility(View.GONE);
                resultLL.setVisibility(View.GONE);
                additionalInfoLL.setVisibility(View.GONE);
                set.setText("Set");
                setName.setText("");
                setList.clear();
                setList.addAll(Arrays.asList("1", "2", "3", "4", "5", "Ended"));
                adapter1.notifyDataSetChanged();
                currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 5) {
                            for (int i = 0; i < position; i++) {
                                setNames[i].setText((String.valueOf(i + 1)));
                            }
                        } else {
                            if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                            }
                            setNames[position].setText(setNames[position].getText().toString() + "*");
                            prevPosition = position;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if (newM) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("date", "Select Date");
                    hashMap.put("time", "Select Time");
                    hashMap.put("eventName", eventNameVal);
                    hashMap.put("team1", team1Name.getText().toString());
                    hashMap.put("team1_score", "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n" +
                            "0");
                    hashMap.put("team2", team2Name.getText().toString());
                    hashMap.put("team2_score", "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n" +
                            "0");
                    hashMap.put("setscore", "");
                    hashMap.put("result", "");
                    hashMap.put("currentTitle", "");
                    hashMap.put("type", type.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                    hashMap.put("setDetails", "Set 1\n\n Set 2\n\n " +
                            "Set 3\n\n Set 4\n\n Set 5");
                    hashMap.put("sport_type", "1");
                    databaseReference.setValue(hashMap);
                }
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String[] team1Score, team2Score;
                        String currentStatus;
                        eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                        team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                        team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                        venue.setText(dataSnapshot.child("venue").getValue().toString());
                        date.setText(dataSnapshot.child("date").getValue().toString());
                        time.setText(dataSnapshot.child("time").getValue().toString());
                        type.setText(dataSnapshot.child("type").getValue().toString());
                        team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        team2Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        set1Team1.setText(team1Score[0]);
                        set2Team1.setText(team1Score[1]);
                        set3Team1.setText(team1Score[2]);
                        set4Team1.setText(team1Score[3]);
                        set5Team1.setText(team1Score[4]);
                        set1Team2.setText(team2Score[0]);
                        set2Team2.setText(team2Score[1]);
                        set3Team2.setText(team2Score[2]);
                        set4Team2.setText(team2Score[3]);
                        set5Team2.setText(team2Score[4]);
                        currentStatus = dataSnapshot.child("when").getValue().toString();
                        if (currentStatus.equals("live")) {
                            status.setSelection(0);
                        } else if (currentStatus.equals("past")) {
                            status.setSelection(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                        if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                            Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                        } else {
                            updateProgress.setVisibility(View.VISIBLE);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("date", date.getText().toString());
                            hashMap.put("time", time.getText().toString());
                            hashMap.put("eventName", eventName.getText().toString());
                            hashMap.put("team1", team1Name.getText().toString());
                            hashMap.put("team1_score", set1Team1.getText().toString() + "\n\n" +
                                    set2Team1.getText().toString() + "\n\n" +
                                    set3Team1.getText().toString() + "\n\n" +
                                    set4Team1.getText().toString() + "\n\n" +
                                    set5Team1.getText().toString());
                            hashMap.put("team2", team2Name.getText().toString());
                            hashMap.put("team2_score", set1Team2.getText().toString() + "\n\n" +
                                    set2Team2.getText().toString() + "\n\n" +
                                    set3Team2.getText().toString() + "\n\n" +
                                    set4Team2.getText().toString() + "\n\n" +
                                    set5Team2.getText().toString());
                            hashMap.put("setscore", "");
                            hashMap.put("result", "");
                            hashMap.put("currentTitle", "");
                            hashMap.put("type", type.getText().toString());
                            hashMap.put("venue", venue.getText().toString());
                            hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                            hashMap.put("setDetails", "Set " + setNames[0].getText().toString() + "\n\n Set " + setNames[1].getText().toString() + "\n\n " +
                                    "Set " + setNames[2].getText().toString() + "\n\n Set " + setNames[3].getText().toString() + "\n\n Set " + setNames[4].getText().toString());
                            hashMap.put("sport_type", "1");
                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    updateProgress.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please retry",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
                        }
                    }
                });
                break;
            case "Chess":
                team3LL.setVisibility(View.GONE);
                set5.setVisibility(View.GONE);
                set6.setVisibility(View.GONE);
                set7.setVisibility(View.GONE);
                set8.setVisibility(View.GONE);
                set9.setVisibility(View.GONE);
                set10.setVisibility(View.GONE);
                set11.setVisibility(View.GONE);
                set12.setVisibility(View.GONE);
                set13.setVisibility(View.GONE);
                set14.setVisibility(View.GONE);
                set15.setVisibility(View.GONE);
                currentSetLL.setVisibility(View.GONE);
                current.setVisibility(View.GONE);
                set1Type.setVisibility(View.GONE);
                set2Type.setVisibility(View.GONE);
                set3Type.setVisibility(View.GONE);
                set4Type.setVisibility(View.GONE);
                set5Type.setVisibility(View.GONE);
                set6Type.setVisibility(View.GONE);
                set7Type.setVisibility(View.GONE);
                set8Type.setVisibility(View.GONE);
                set9Type.setVisibility(View.GONE);
                set10Type.setVisibility(View.GONE);
                set11Type.setVisibility(View.GONE);
                set12Type.setVisibility(View.GONE);
                set13Type.setVisibility(View.GONE);
                set14Type.setVisibility(View.GONE);
                set15Type.setVisibility(View.GONE);
                resultLL.setVisibility(View.GONE);
                additionalInfoLL.setVisibility(View.GONE);
                set.setText("Table");
                setName.setText("");
                if (newM) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("date", "Select Date");
                    hashMap.put("time", "Select Time");
                    hashMap.put("eventName", eventNameVal);
                    hashMap.put("team1", team1Name.getText().toString());
                    hashMap.put("team1_score", "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n"
                            + "0" + "\n\n" + "0");
                    hashMap.put("team2", team2Name.getText().toString());
                    hashMap.put("team2_score", "0" + "\n\n" + "0" + "\n\n" + "0" + "\n\n"
                            + "0" + "\n\n" + "0");
                    hashMap.put("setscore", "");
                    hashMap.put("result", "");
                    hashMap.put("currentTitle", "");
                    hashMap.put("type", type.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                    hashMap.put("setDetails", "Table 1\n\nTable 2\n\nTable 3" +
                            "\n\nTable 4\n\nTotal");
                    hashMap.put("sport_type", "1");
                    databaseReference.setValue(hashMap);
                }
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String[] team1Score, team2Score;
                        String currentStatus;
                        eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                        team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                        team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                        venue.setText(dataSnapshot.child("venue").getValue().toString());
                        date.setText(dataSnapshot.child("date").getValue().toString());
                        time.setText(dataSnapshot.child("time").getValue().toString());
                        type.setText(dataSnapshot.child("type").getValue().toString());
                        team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                split("\\s+");
                        set1Team1.setText(team1Score[0]);
                        set2Team1.setText(team1Score[1]);
                        set3Team1.setText(team1Score[2]);
                        set4Team1.setText(team1Score[3]);
                        set1Team2.setText(team2Score[0]);
                        set2Team2.setText(team2Score[1]);
                        set3Team2.setText(team2Score[2]);
                        set4Team2.setText(team2Score[3]);
                        currentStatus = dataSnapshot.child("when").getValue().toString();
                        if (currentStatus.equals("live")) {
                            status.setSelection(0);
                        } else if (currentStatus.equals("past")) {
                            status.setSelection(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                        if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                            Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                        } else {
                            updateProgress.setVisibility(View.VISIBLE);
                            HashMap<String, String> hashMap = new HashMap<>();
                            Integer team1Total = Integer.parseInt(set1Team1.getText().toString()) +
                                    Integer.parseInt(set2Team1.getText().toString()) +
                                    Integer.parseInt(set3Team1.getText().toString()) +
                                    Integer.parseInt(set4Team1.getText().toString());
                            Integer team2Total = Integer.parseInt(set1Team2.getText().toString()) +
                                    Integer.parseInt(set2Team2.getText().toString()) +
                                    Integer.parseInt(set3Team2.getText().toString()) +
                                    Integer.parseInt(set4Team2.getText().toString());
                            hashMap.put("date", date.getText().toString());
                            hashMap.put("time", time.getText().toString());
                            hashMap.put("eventName", eventName.getText().toString());
                            hashMap.put("team1", team1Name.getText().toString());
                            hashMap.put("team1_score", set1Team1.getText().toString() + "\n\n" +
                                    set2Team1.getText().toString() + "\n\n" +
                                    set3Team1.getText().toString() + "\n\n" +
                                    set4Team1.getText().toString() + "\n\n" + team1Total);
                            hashMap.put("team2", team2Name.getText().toString());
                            hashMap.put("team2_score", set1Team2.getText().toString() + "\n\n" +
                                    set2Team2.getText().toString() + "\n\n" +
                                    set3Team2.getText().toString() + "\n\n" +
                                    set4Team2.getText().toString() + "\n\n" + team2Total);
                            hashMap.put("setscore", "");
                            hashMap.put("result", "");
                            hashMap.put("currentTitle", "");
                            hashMap.put("type", type.getText().toString());
                            hashMap.put("venue", venue.getText().toString());
                            hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                            hashMap.put("setDetails", "Table 1\n\nTable 2\n\nTable 3" +
                                    "\n\nTable 4\n\nTotal");
                            hashMap.put("sport_type", "1");
                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    updateProgress.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please retry",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
                        }
                    }
                });
                break;
            case "Badminton":
            case "Squash":
                team3LL.setVisibility(View.GONE);
                set10.setVisibility(View.GONE);
                set11.setVisibility(View.GONE);
                set12.setVisibility(View.GONE);
                set13.setVisibility(View.GONE);
                set14.setVisibility(View.GONE);
                set15.setVisibility(View.GONE);
                current.setVisibility(View.GONE);
                set1Name.setText("1");
                set2Name.setText("2");
                set3Name.setText("3");
                set4Name.setText("1");
                set5Name.setText("2");
                set6Name.setText("3");
                set7Name.setText("1");
                set8Name.setText("2");
                set9Name.setText("3");
                set1Type.setText("Singles");
                set2Type.setText("Singles");
                set3Type.setText("Singles");
                set4Type.setText("Doubles");
                set5Type.setText("Doubles");
                set6Type.setText("Doubles");
                set7Type.setText("R Singles");
                set8Type.setText("R Singles");
                set9Type.setText("R Singles");
                set10Type.setVisibility(View.GONE);
                set11Type.setVisibility(View.GONE);
                set12Type.setVisibility(View.GONE);
                set13Type.setVisibility(View.GONE);
                set14Type.setVisibility(View.GONE);
                set15Type.setVisibility(View.GONE);
                resultLL.setVisibility(View.GONE);
                setList.clear();
                setList.addAll(Arrays.asList("Singles 1", "Singles 2", "Singles 3", "Doubles 1", "Doubles 2", "Doubles 3", "R.Singles 1", "R.Singles 2", "R.Singles 3", "Ended"));
                adapter1.notifyDataSetChanged();
                currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 9) {
                            for (int i = 0; i < position; i++) {
                                setNames[i].setText((String.valueOf(i % 3 + 1)));
                            }
                        } else {
                            if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                            }
                            setNames[position].setText(setNames[position].getText().toString() + "*");
                            prevPosition = position;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if (newM) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("date", "Select Date");
                    hashMap.put("time", "Select Time");
                    hashMap.put("eventName", eventNameVal);
                    hashMap.put("team1", team1Name.getText().toString());
                    hashMap.put("team1_score", "\n\n0\n\n0\n\n0\n\n\n\n0\n\n0\n\n0\n\n\n\n" +
                            "0\n\n0\n\n0");
                    hashMap.put("team2", team2Name.getText().toString());
                    hashMap.put("team2_score", "\n\n0\n\n0\n\n0\n\n\n\n0\n\n0\n\n0\n\n\n\n" +
                            "0\n\n0\n\n0");
                    hashMap.put("setscore", "");
                    hashMap.put("result", "Shrey");
                    hashMap.put("currentTitle", "");
                    hashMap.put("type", type.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                    hashMap.put("setDetails", "Singles\n\nSet 1\n\nSet 2\n\nSet 3\n\nDoubles" +
                            "\n\nSet 1\n\nSet 2\n\nSet3\n\nR. Singles\n\nSet1\n\nSet2\n\nSet3");
                    hashMap.put("sport_type", "1");
                    databaseReference.setValue(hashMap);
                }

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String[] team1Score, team2Score;
                        String currentStatus;
                        eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                        team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                        team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                        venue.setText(dataSnapshot.child("venue").getValue().toString());
                        date.setText(dataSnapshot.child("date").getValue().toString());
                        time.setText(dataSnapshot.child("time").getValue().toString());
                        type.setText(dataSnapshot.child("type").getValue().toString());
                        additionalInfo.setText(dataSnapshot.child("currentTitle").
                                getValue().toString());
                        team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                split("\\s+");
                        set1Team1.setText(team1Score[1]);
                        set2Team1.setText(team1Score[2]);
                        set3Team1.setText(team1Score[3]);
                        set4Team1.setText(team1Score[4]);
                        set5Team1.setText(team1Score[5]);
                        set6Team1.setText(team1Score[6]);
                        set7Team1.setText(team1Score[7]);
                        set8Team1.setText(team1Score[8]);
                        set9Team1.setText(team1Score[9]);
                        set1Team2.setText(team2Score[1]);
                        set2Team2.setText(team2Score[2]);
                        set3Team2.setText(team2Score[3]);
                        set4Team2.setText(team2Score[4]);
                        set5Team2.setText(team2Score[5]);
                        set6Team2.setText(team2Score[6]);
                        set7Team2.setText(team2Score[7]);
                        set8Team2.setText(team2Score[8]);
                        set9Team2.setText(team2Score[9]);
                        currentStatus = dataSnapshot.child("when").getValue().toString();
                        if (currentStatus.equals("live")) {
                            status.setSelection(0);
                        } else if (currentStatus.equals("past")) {
                            status.setSelection(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                        if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                            Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                        } else {
                            updateProgress.setVisibility(View.VISIBLE);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("date", date.getText().toString());
                            hashMap.put("time", time.getText().toString());
                            hashMap.put("eventName", eventName.getText().toString());
                            hashMap.put("team1", team1Name.getText().toString());
                            hashMap.put("team1_score", "\n\n" + set1Team1.getText().toString() + "\n"
                                    + set2Team1.getText().toString() + "\n"
                                    + set3Team1.getText().toString() + "\n\n\n\n"
                                    + set4Team1.getText().toString() + "\n"
                                    + set5Team1.getText().toString() + "\n"
                                    + set6Team1.getText().toString() + "\n\n\n\n"
                                    + set7Team1.getText().toString() + "\n"
                                    + set8Team1.getText().toString() + "\n"
                                    + set9Team1.getText().toString());
                            hashMap.put("team2", team2Name.getText().toString());
                            hashMap.put("team2_score", "\n\n" + set1Team2.getText().toString() + "\n"
                                    + set2Team2.getText().toString() + "\n"
                                    + set3Team2.getText().toString() + "\n\n\n\n"
                                    + set4Team2.getText().toString() + "\n"
                                    + set5Team2.getText().toString() + "\n"
                                    + set6Team2.getText().toString() + "\n\n\n\n"
                                    + set7Team2.getText().toString() + "\n"
                                    + set8Team2.getText().toString() + "\n"
                                    + set9Team2.getText().toString());
                            hashMap.put("setscore", "");
                            hashMap.put("currentTitle", additionalInfo.getText().toString());
                            hashMap.put("result", "Shrey");
                            hashMap.put("type", type.getText().toString());
                            hashMap.put("venue", venue.getText().toString());
                            hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                            hashMap.put("setDetails", "Singles\n\nSet " + set1Name.getText().toString() + "\nSet " + set2Name.getText().toString() + "\nSet " + set3Name.getText().toString() + "\n\nDoubles" +
                                    "\n\nSet " + set4Name.getText().toString() + "\nSet " + set5Name.getText().toString() + "\nSet " + set6Name.getText().toString() + "\n\nR. Singles\n\nSet " + set7Name.getText().toString() + "\nSet " + set8Name.getText().toString() +
                                    "\nSet " + set9Name.getText().toString());
                            hashMap.put("sport_type", "1");
                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    updateProgress.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please retry",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
                        }
                    }
                });
                break;
            case "Tabletennis":
                if (gender.equals("female")) {
                    team3LL.setVisibility(View.GONE);
                    set10.setVisibility(View.GONE);
                    set11.setVisibility(View.GONE);
                    set12.setVisibility(View.GONE);
                    set13.setVisibility(View.GONE);
                    set14.setVisibility(View.GONE);
                    set15.setVisibility(View.GONE);
                    current.setVisibility(View.GONE);
                    set1Name.setText("1");
                    set2Name.setText("2");
                    set3Name.setText("3");
                    set4Name.setText("1");
                    set5Name.setText("2");
                    set6Name.setText("3");
                    set7Name.setText("1");
                    set8Name.setText("2");
                    set9Name.setText("3");
                    set1Type.setText("Singles");
                    set2Type.setText("Singles");
                    set3Type.setText("Singles");
                    set4Type.setText("Doubles");
                    set5Type.setText("Doubles");
                    set6Type.setText("Doubles");
                    set7Type.setText("R Singles");
                    set8Type.setText("R Singles");
                    set9Type.setText("R Singles");
                    set10Type.setVisibility(View.GONE);
                    set11Type.setVisibility(View.GONE);
                    set12Type.setVisibility(View.GONE);
                    set13Type.setVisibility(View.GONE);
                    set14Type.setVisibility(View.GONE);
                    set15Type.setVisibility(View.GONE);
                    resultLL.setVisibility(View.GONE);
                    setList.clear();
                    setList.addAll(Arrays.asList("Singles 1", "Singles 2", "Singles 3", "Doubles 1", "Doubles 2", "Doubles 3", "R.Singles 1", "R.Singles 2", "R.Singles 3", "Ended"));
                    adapter1.notifyDataSetChanged();
                    currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 9) {
                                for (int i = 0; i < position; i++) {
                                    setNames[i].setText((String.valueOf(i % 3 + 1)));
                                }
                            } else {
                                if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                    setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                                }
                                setNames[position].setText(setNames[position].getText().toString() + "*");
                                prevPosition = position;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    if (newM) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("date", "Select Date");
                        hashMap.put("time", "Select Time");
                        hashMap.put("eventName", eventNameVal);
                        hashMap.put("team1", team1Name.getText().toString());
                        hashMap.put("team1_score", "\n\n0\n\n0\n\n0\n\n\n\n0\n\n0\n\n0\n\n\n\n" +
                                "0\n\n0\n\n0");
                        hashMap.put("team2", team2Name.getText().toString());
                        hashMap.put("team2_score", "\n\n0\n\n0\n\n0\n\n\n\n0\n\n0\n\n0\n\n\n\n" +
                                "0\n\n0\n\n0");
                        hashMap.put("setscore", "");
                        hashMap.put("result", "Shrey");
                        hashMap.put("currentTitle", "");
                        hashMap.put("type", type.getText().toString());
                        hashMap.put("venue", venue.getText().toString());
                        hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                        hashMap.put("setDetails", "Singles\n\nSet 1\nSet 2\nSet 3\n\nDoubles" +
                                "\n\nSet 1\nSet 2\nSet 3\n\nR. Singles\n\nSet 1\nSet 2\nSet 3");
                        hashMap.put("sport_type", "1");
                        databaseReference.setValue(hashMap);
                    }

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String[] team1Score, team2Score;
                            String currentStatus;
                            eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                            team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                            team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                            venue.setText(dataSnapshot.child("venue").getValue().toString());
                            date.setText(dataSnapshot.child("date").getValue().toString());
                            time.setText(dataSnapshot.child("time").getValue().toString());
                            type.setText(dataSnapshot.child("type").getValue().toString());
                            additionalInfo.setText(dataSnapshot.child("currentTitle").
                                    getValue().toString());
                            team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                    split("\\s+");
                            team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                    split("\\s+");
                            set1Team1.setText(team1Score[1]);
                            set2Team1.setText(team1Score[2]);
                            set3Team1.setText(team1Score[3]);
                            set4Team1.setText(team1Score[4]);
                            set5Team1.setText(team1Score[5]);
                            set6Team1.setText(team1Score[6]);
                            set7Team1.setText(team1Score[7]);
                            set8Team1.setText(team1Score[8]);
                            set9Team1.setText(team1Score[9]);
                            set1Team2.setText(team2Score[1]);
                            set2Team2.setText(team2Score[2]);
                            set3Team2.setText(team2Score[3]);
                            set4Team2.setText(team2Score[4]);
                            set5Team2.setText(team2Score[5]);
                            set6Team2.setText(team2Score[6]);
                            set7Team2.setText(team2Score[7]);
                            set8Team2.setText(team2Score[8]);
                            set9Team2.setText(team2Score[9]);
                            currentStatus = dataSnapshot.child("when").getValue().toString();
                            if (currentStatus.equals("live")) {
                                status.setSelection(0);
                            } else if (currentStatus.equals("past")) {
                                status.setSelection(1);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                            if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                                Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                            } else {
                                updateProgress.setVisibility(View.VISIBLE);
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("date", date.getText().toString());
                                hashMap.put("time", time.getText().toString());
                                hashMap.put("eventName", eventName.getText().toString());
                                hashMap.put("team1", team1Name.getText().toString());
                                hashMap.put("team1_score", "\n\n" + set1Team1.getText().toString() + "\n"
                                        + set2Team1.getText().toString() + "\n"
                                        + set3Team1.getText().toString() + "\n\n\n\n"
                                        + set4Team1.getText().toString() + "\n"
                                        + set5Team1.getText().toString() + "\n"
                                        + set6Team1.getText().toString() + "\n\n\n\n"
                                        + set7Team1.getText().toString() + "\n"
                                        + set8Team1.getText().toString() + "\n"
                                        + set9Team1.getText().toString());
                                hashMap.put("team2", team2Name.getText().toString());
                                hashMap.put("team2_score", "\n\n" + set1Team2.getText().toString() + "\n"
                                        + set2Team2.getText().toString() + "\n"
                                        + set3Team2.getText().toString() + "\n\n\n\n"
                                        + set4Team2.getText().toString() + "\n"
                                        + set5Team2.getText().toString() + "\n"
                                        + set6Team2.getText().toString() + "\n\n\n\n"
                                        + set7Team2.getText().toString() + "\n"
                                        + set8Team2.getText().toString() + "\n"
                                        + set9Team2.getText().toString());
                                hashMap.put("setscore", "");
                                hashMap.put("currentTitle", additionalInfo.getText().toString());
                                hashMap.put("result", "Shrey");
                                hashMap.put("type", type.getText().toString());
                                hashMap.put("venue", venue.getText().toString());
                                hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                                hashMap.put("setDetails", "Singles\n\nSet " + set1Name.getText().toString() + "\nSet " + set2Name.getText().toString() + "\nSet " + set3Name.getText().toString() + "\n\nDoubles" +
                                        "\n\nSet " + set4Name.getText().toString() + "\nSet " + set5Name.getText().toString() + "\nSet " + set6Name.getText().toString() + "\n\nR. Singles\n\nSet " + set7Name.getText().toString() + "\nSet " + set8Name.getText().toString() +
                                        "\nSet " + set9Name.getText().toString());
                                hashMap.put("sport_type", "1");
                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        updateProgress.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Please retry",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }


                                });
                            }
                        }
                    });
                } else {
                    team3LL.setVisibility(View.GONE);
                    current.setVisibility(View.GONE);
                    set1Name.setText("1");
                    set2Name.setText("2");
                    set3Name.setText("3");
                    set4Name.setText("1");
                    set5Name.setText("2");
                    set6Name.setText("3");
                    set7Name.setText("1");
                    set8Name.setText("2");
                    set9Name.setText("3");
                    set10Name.setText("1");
                    set11Name.setText("2");
                    set12Name.setText("3");
                    set13Name.setText("1");
                    set14Name.setText("2");
                    set15Name.setText("3");
                    set1Type.setText("Singles");
                    set2Type.setText("Singles");
                    set3Type.setText("Singles");
                    set4Type.setText("Singles");
                    set5Type.setText("Singles");
                    set6Type.setText("Singles");
                    set7Type.setText("Singles");
                    set8Type.setText("Singles");
                    set9Type.setText("Singles");
                    set10Type.setText("Singles");
                    set11Type.setText("Singles");
                    set12Type.setText("Singles");
                    set13Type.setText("Singles");
                    set14Type.setText("Singles");
                    set15Type.setText("Singles");
                    resultLL.setVisibility(View.GONE);
                    setList.clear();
                    setList.addAll(Arrays.asList("Singles1 1", "Singles1 2", "Singles1 3", "Singles2 1", "Singles2 2", "Singles2 3", "Singles3 1", "Singles3 2", "Singles3 3", "Singles4 1", "Singles4 2", "Singles4 3", "Singles5 1", "Singles5 2", "Singles5 3", "Ended"));
                    adapter1.notifyDataSetChanged();
                    currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 15) {
                                for (int i = 0; i < position; i++) {
                                    setNames[i].setText((String.valueOf(i % 3 + 1)));
                                }
                            } else {
                                if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                    setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                                }
                                setNames[position].setText(setNames[position].getText().toString() + "*");
                                prevPosition = position;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    if (newM) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("date", "Select Date");
                        hashMap.put("time", "Select Time");
                        hashMap.put("eventName", eventNameVal);
                        hashMap.put("team1", team1Name.getText().toString());
                        hashMap.put("team1_score", "\n\n0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n" +
                                "0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n0\n0\n0");
                        hashMap.put("team2", team2Name.getText().toString());
                        hashMap.put("team2_score", "\n\n0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n" +
                                "0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n0\n0\n0");
                        hashMap.put("setscore", "");
                        hashMap.put("result", "Shrey");
                        hashMap.put("currentTitle", "");
                        hashMap.put("type", type.getText().toString());
                        hashMap.put("venue", venue.getText().toString());
                        hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                        hashMap.put("setDetails", "Singles 1\n\nSet 1\nSet 2\nSet 3\n\n" +
                                "Singles 2\n\nSet 1\nSet 2\nSet 3\n\n" +
                                "Singles 3\n\nSet 1\nSet 2\nSet 3\n\n" +
                                "Singles 4\n\nSet 1\nSet 2\nSet 3\n\n" +
                                "Singles 5\n\nSet 1\nSet 2\nSet 3");
                        hashMap.put("sport_type", "1");
                        databaseReference.setValue(hashMap);
                    }

                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String[] team1Score, team2Score;
                            String currentStatus;
                            eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                            team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                            team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                            venue.setText(dataSnapshot.child("venue").getValue().toString());
                            date.setText(dataSnapshot.child("date").getValue().toString());
                            time.setText(dataSnapshot.child("time").getValue().toString());
                            type.setText(dataSnapshot.child("type").getValue().toString());
                            additionalInfo.setText(dataSnapshot.child("currentTitle").
                                    getValue().toString());
                            team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                    split("\\s+");
                            team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                    split("\\s+");
                            set1Team1.setText(team1Score[1]);
                            set2Team1.setText(team1Score[2]);
                            set3Team1.setText(team1Score[3]);
                            set4Team1.setText(team1Score[4]);
                            set5Team1.setText(team1Score[5]);
                            set6Team1.setText(team1Score[6]);
                            set7Team1.setText(team1Score[7]);
                            set8Team1.setText(team1Score[8]);
                            set9Team1.setText(team1Score[9]);
                            set10Team1.setText(team1Score[10]);
                            set11Team1.setText(team1Score[11]);
                            set12Team1.setText(team1Score[12]);
                            set13Team1.setText(team1Score[13]);
                            set14Team1.setText(team1Score[14]);
                            set15Team1.setText(team1Score[15]);
                            set1Team2.setText(team2Score[1]);
                            set2Team2.setText(team2Score[2]);
                            set3Team2.setText(team2Score[3]);
                            set4Team2.setText(team2Score[4]);
                            set5Team2.setText(team2Score[5]);
                            set6Team2.setText(team2Score[6]);
                            set7Team2.setText(team2Score[7]);
                            set8Team2.setText(team2Score[8]);
                            set9Team2.setText(team2Score[9]);
                            set10Team2.setText(team1Score[10]);
                            set11Team2.setText(team1Score[11]);
                            set12Team2.setText(team1Score[12]);
                            set13Team2.setText(team1Score[13]);
                            set14Team2.setText(team1Score[14]);
                            set15Team2.setText(team1Score[15]);


                            currentStatus = dataSnapshot.child("when").getValue().toString();
                            if (currentStatus.equals("live")) {
                                status.setSelection(0);
                            } else if (currentStatus.equals("past")) {
                                status.setSelection(1);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                            if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                                Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                            } else {
                                updateProgress.setVisibility(View.VISIBLE);
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("date", date.getText().toString());
                                hashMap.put("time", time.getText().toString());
                                hashMap.put("eventName", eventName.getText().toString());
                                hashMap.put("team1", team1Name.getText().toString());
                                hashMap.put("team1_score", "\n\n" + set1Team1.getText().toString() + "\n"
                                        + set2Team1.getText().toString() + "\n"
                                        + set3Team1.getText().toString() + "\n\n\n\n"
                                        + set4Team1.getText().toString() + "\n"
                                        + set5Team1.getText().toString() + "\n"
                                        + set6Team1.getText().toString() + "\n\n\n\n"
                                        + set7Team1.getText().toString() + "\n"
                                        + set8Team1.getText().toString() + "\n"
                                        + set9Team1.getText().toString() + "\n\n\n\n"
                                        + set10Team1.getText().toString() + "\n"
                                        + set11Team1.getText().toString() + "\n"
                                        + set12Team1.getText().toString() + "\n\n\n\n"
                                        + set13Team1.getText().toString() + "\n"
                                        + set14Team1.getText().toString() + "\n"
                                        + set15Team1.getText().toString());
                                hashMap.put("team2", team2Name.getText().toString());
                                hashMap.put("team2_score", "\n\n" + set1Team2.getText().toString() + "\n"
                                        + set2Team2.getText().toString() + "\n"
                                        + set3Team2.getText().toString() + "\n\n\n\n"
                                        + set4Team2.getText().toString() + "\n"
                                        + set5Team2.getText().toString() + "\n"
                                        + set6Team2.getText().toString() + "\n\n\n\n"
                                        + set7Team2.getText().toString() + "\n"
                                        + set8Team2.getText().toString() + "\n"
                                        + set9Team2.getText().toString() + "\n\n\n\n"
                                        + set10Team2.getText().toString() + "\n"
                                        + set11Team2.getText().toString() + "\n"
                                        + set12Team2.getText().toString() + "\n\n\n\n"
                                        + set13Team2.getText().toString() + "\n"
                                        + set14Team2.getText().toString() + "\n"
                                        + set15Team2.getText().toString());
                                hashMap.put("setscore", "");
                                hashMap.put("currentTitle", additionalInfo.getText().toString());
                                hashMap.put("result", "Shrey");
                                hashMap.put("type", type.getText().toString());
                                hashMap.put("venue", venue.getText().toString());
                                hashMap.put("setDetails", "Singles 1\n\nSet " + set1Name.getText().toString() + "\nSet " + set2Name.getText().toString() + "\nSet " + set3Name.getText().toString() + "\n\n" +
                                        "Singles 2\n\nSet " + set4Name.getText().toString() + "\nSet " + set5Name.getText().toString() + "\nSet " + set6Name.getText().toString() + "\n\n" +
                                        "Singles 3\n\nSet " + set7Name.getText().toString() + "\nSet " + set8Name.getText().toString() + "\nSet " + set9Name.getText().toString() + "\n\n" +
                                        "Singles 4\n\nSet " + set10Name.getText().toString() + "\nSet " + set11Name.getText().toString() + "\nSet " + set12Name.getText().toString() + "\n\n" +
                                        "Singles 5\n\nSet " + set13Name.getText().toString() + "\nSet " + set14Name.getText().toString() + "\nSet " + set15Name.getText().toString());
                                hashMap.put("sport_type", "1");
                                hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        updateProgress.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                    Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Please retry",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                    break;
            case "Lawntennis":
                team3LL.setVisibility(View.GONE);
                set11.setVisibility(View.GONE);
                set12.setVisibility(View.GONE);
                set13.setVisibility(View.GONE);
                set14.setVisibility(View.GONE);
                set15.setVisibility(View.GONE);
                set1Name.setText("1");
                set2Name.setText("2");
                set3Name.setText("3");
                set4Name.setText("1");
                set5Name.setText("2");
                set6Name.setText("3");
                set7Name.setText("1");
                set8Name.setText("2");
                set9Name.setText("3");
                set10Name.setText("Score");
                set1Type.setText("Singles");
                set2Type.setText("Singles");
                set3Type.setText("Singles");
                set4Type.setText("Doubles");
                set5Type.setText("Doubles");
                set6Type.setText("Doubles");
                set7Type.setText("R Singles");
                set8Type.setText("R Singles");
                set9Type.setText("R Singles");
                set10Type.setText("Game");
                set11Type.setVisibility(View.GONE);
                set12Type.setVisibility(View.GONE);
                set13Type.setVisibility(View.GONE);
                set14Type.setVisibility(View.GONE);
                set15Type.setVisibility(View.GONE);
                resultLL.setVisibility(View.GONE);
                currentName.setText("Number of Sets");
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        new ArrayList<>(Arrays.asList("3", "1")));
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                currentSpinner.setAdapter(adapter2);
                currentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 1) {
                            setList.clear();
                            setList.addAll(Arrays.asList("Singles", "Doubles", "R. Singles", "Ended"));
                            adapter1.notifyDataSetChanged();
                            set1Name.setText("Singles");
                            set2Name.setText("Doubles");
                            set3Name.setText("R. Singles");
                            set2Type.setText("Doubles");
                            set3Type.setText("R. Singles");
                            set4.setVisibility(View.GONE);
                            set5.setVisibility(View.GONE);
                            set6.setVisibility(View.GONE);
                            set7.setVisibility(View.GONE);
                            set8.setVisibility(View.GONE);
                            set9.setVisibility(View.GONE);
                            currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position == 4) {
                                        setNames[0].setText("Singles");
                                        setNames[1].setText("Doubles");
                                        setNames[2].setText("R. Singles");
                                    } else {
                                        if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                            setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                                        }
                                        setNames[position].setText(setNames[position].getText().toString() + "*");
                                        prevPosition = position;
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        } else {
                            setList.clear();
                            setList.addAll(Arrays.asList("Singles 1", "Singles 2", "Singles 3", "Doubles 1", "Doubles 2", "Doubles 3", "R.Singles 1", "R.Singles 2", "R.Singles 3", "Ended"));
                            adapter1.notifyDataSetChanged();
                            set2Name.setText("2");
                            set3Name.setText("3");
                            set2Type.setText("Singles");
                            set3Type.setText("Singles");
                            set4.setVisibility(View.VISIBLE);
                            set5.setVisibility(View.VISIBLE);
                            set6.setVisibility(View.VISIBLE);
                            set7.setVisibility(View.VISIBLE);
                            set8.setVisibility(View.VISIBLE);
                            set9.setVisibility(View.VISIBLE);
                            currentSetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position == 9) {
                                        for (int i = 0; i < position; i++) {
                                            setNames[i].setText((String.valueOf(i % 3 + 1)));
                                        }
                                    } else {
                                        if (setNames[prevPosition].getText().toString().charAt(setNames[prevPosition].getText().toString().length() - 1) == '*') {
                                            setNames[prevPosition].setText(setNames[prevPosition].getText().toString().substring(0, setNames[prevPosition].getText().toString().length() - 1));
                                        }
                                        setNames[position].setText(setNames[position].getText().toString() + "*");
                                        prevPosition = position;
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if (newM) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("date", "Select Date");
                    hashMap.put("time", "Select Time");
                    hashMap.put("eventName", eventNameVal);
                    hashMap.put("team1", team1Name.getText().toString());
                    hashMap.put("team1_score", "\n\n0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n0\n0\n0");
                    hashMap.put("team2", team2Name.getText().toString());
                    hashMap.put("team2_score", "\n\n0\n0\n0\n\n\n\n0\n0\n0\n\n\n\n0\n0\n0");
                    hashMap.put("setscore", "");
                    hashMap.put("result", "");
                    hashMap.put("currentTitle", "");
                    hashMap.put("type", type.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                    hashMap.put("setDetails", "Singles\n\nSet 1\nSet 2\nSet 3\n\nDoubles" +
                            "\n\nSet 1\nSet 2\nSet 3\n\nSingles\n\nSet 1\nSet 2\nSet 3");
                    hashMap.put("sport_type", "1");
                    databaseReference.setValue(hashMap);
                }

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String[] team1Score, team2Score;
                        String currentStatus;
                        eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                        team1Name.setText(dataSnapshot.child("team1").getValue().toString());
                        team2Name.setText(dataSnapshot.child("team2").getValue().toString());
                        venue.setText(dataSnapshot.child("venue").getValue().toString());
                        date.setText(dataSnapshot.child("date").getValue().toString());
                        time.setText(dataSnapshot.child("time").getValue().toString());
                        type.setText(dataSnapshot.child("type").getValue().toString());
                        additionalInfo.setText(dataSnapshot.child("currentTitle").
                                getValue().toString());
                        team1Score = dataSnapshot.child("team1_score").getValue().toString().
                                split("\\s+");
                        team2Score = dataSnapshot.child("team2_score").getValue().toString().
                                split("\\s+");
                        if (team1Score.length == 4) {
                            currentSpinner.setSelection(1);
                        }
                        set1Team1.setText(team1Score[1]);
                        set2Team1.setText(team1Score[2]);
                        set3Team1.setText(team1Score[3]);
                        set10Team1.setText(team1Score[0]);
                        set1Team2.setText(team2Score[1]);
                        set2Team2.setText(team2Score[2]);
                        set3Team2.setText(team2Score[3]);
                        set10Team2.setText(team2Score[0]);
                        if (currentSpinner.getSelectedItemPosition() == 0) {
                            set4Team1.setText(team1Score[4]);
                            set5Team1.setText(team1Score[5]);
                            set6Team1.setText(team1Score[6]);
                            set7Team1.setText(team1Score[7]);
                            set8Team1.setText(team1Score[8]);
                            set9Team1.setText(team1Score[9]);
                            set4Team2.setText(team2Score[4]);
                            set5Team2.setText(team2Score[5]);
                            set6Team2.setText(team2Score[6]);
                            set7Team2.setText(team2Score[7]);
                            set8Team2.setText(team2Score[8]);
                            set9Team2.setText(team2Score[9]);
                        }
                        currentStatus = dataSnapshot.child("when").getValue().toString();
                        if (currentStatus.equals("live")) {
                            status.setSelection(0);
                        } else if (currentStatus.equals("past")) {
                            status.setSelection(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scoreTextSetter(new EditText[]{set1Team1, set1Team2, set2Team1, set2Team2, set3Team1, set3Team2, set4Team1, set4Team2, set5Team1, set5Team2, set6Team1, set6Team2, set7Team1, set7Team2, set8Team1, set8Team2, set9Team1, set9Team2, set10Team1, set10Team2});
                        if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                            Toast.makeText(AdminRacketSpecial.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                        } else {
                            updateProgress.setVisibility(View.VISIBLE);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("date", date.getText().toString());
                            hashMap.put("time", time.getText().toString());
                            hashMap.put("eventName", eventName.getText().toString());
                            hashMap.put("team1", team1Name.getText().toString());
                            hashMap.put("team2", team2Name.getText().toString());
                            hashMap.put("setscore", "");
                            hashMap.put("currentTitle", additionalInfo.getText().toString());
                            hashMap.put("result", "");
                            hashMap.put("type", type.getText().toString());
                            hashMap.put("venue", venue.getText().toString());
                            hashMap.put("when", status.getSelectedItem().toString().toLowerCase());
                            hashMap.put("sport_type", "1");
                            if (currentSpinner.getSelectedItemPosition() == 0) {
                                hashMap.put("team1_score", set10Team1.getText().toString() + "\n\n"
                                        + set1Team1.getText().toString() + "\n"
                                        + set2Team1.getText().toString() + "\n"
                                        + set3Team1.getText().toString() + "\n\n\n\n"
                                        + set4Team1.getText().toString() + "\n"
                                        + set5Team1.getText().toString() + "\n"
                                        + set6Team1.getText().toString() + "\n\n\n\n"
                                        + set7Team1.getText().toString() + "\n"
                                        + set8Team1.getText().toString() + "\n"
                                        + set9Team1.getText().toString());
                                hashMap.put("team2_score", set10Team2.getText().toString() + "\n\n"
                                        + set1Team2.getText().toString() + "\n"
                                        + set2Team2.getText().toString() + "\n"
                                        + set3Team2.getText().toString() + "\n\n\n\n"
                                        + set4Team2.getText().toString() + "\n"
                                        + set5Team2.getText().toString() + "\n"
                                        + set6Team2.getText().toString() + "\n\n\n\n"
                                        + set7Team2.getText().toString() + "\n"
                                        + set8Team2.getText().toString() + "\n"
                                        + set9Team2.getText().toString());
                                hashMap.put("setDetails", "Singles\n\nSet " + set1Name.getText().toString() + "\nSet " + set2Name.getText().toString() + "\nSet " + set3Name.getText().toString() + "\n\nDoubles" +
                                        "\n\nSet " + set4Name.getText().toString() + "\nSet " + set5Name.getText().toString() + "\nSet " + set6Name.getText().toString() + "\n\nR. Singles\n\nSet " + set7Name.getText().toString() + "\nSet " + set8Name.getText().toString() +
                                        "\nSet " + set9Name.getText().toString());
                            } else {
                                hashMap.put("team1_score", set10Team1.getText().toString() + "\n\n"
                                        + set1Team1.getText().toString() + "\n\n"
                                        + set2Team1.getText().toString() + "\n\n"
                                        + set3Team1.getText().toString());
                                hashMap.put("team2_score", set10Team2.getText().toString() + "\n\n"
                                        + set1Team2.getText().toString() + "\n\n"
                                        + set2Team2.getText().toString() + "\n\n"
                                        + set3Team2.getText().toString());
                                hashMap.put("setDetails", "Current Game\n" + set1Name.getText().toString() + "\n\n" + set2Name.getText().toString() +
                                        "\n\n" + set3Name.getText().toString());
                            }
                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    updateProgress.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Successfully Updated",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please retry",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }
                });
                break;
        }
    }

    public void scoreTextSetter(EditText[] editTexts) {
        for (EditText editText : editTexts) {
            if (editText.getVisibility() == View.VISIBLE && editText.getText().toString().equals("")) {
                editText.setText("0");
            }
        }
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int hour, minute;
            if (time.getText().toString().equals("Select Time")) {
                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);
            } else {
                String[] setTime = time.getText().toString().split(":");
                hour = Integer.parseInt(setTime[0]);
                minute = Integer.parseInt(setTime[1]);
            }

            return new TimePickerDialog(getActivity(), R.style.Theme_AppCompat_Light_Dialog, this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            time.setText(String.format("%02d:%02d", hourOfDay, minute));
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int year, month, day;
            if (date.getText().toString().equals("Select Date")) {
                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
            } else {
                String[] setDate = date.getText().toString().split("/");
                year = Integer.parseInt(setDate[2]);
                month = Integer.parseInt(setDate[1]) - 1;
                day = Integer.parseInt(setDate[0]);
            }

            return new DatePickerDialog(getActivity(), R.style.Theme_AppCompat_Light_Dialog, this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            date.setText(String.format("%02d/%02d/%04d", day, (month + 1), year));
        }
    }
}
