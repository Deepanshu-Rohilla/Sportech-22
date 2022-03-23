package com.sportech20.iitd.Admin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

public class AdminNonRacketMatch extends AppCompatActivity {

    static Button date, time;
    Button update;
    EditText team1, team2, score1, score2, eventName, venue, result, description, info;
    ProgressBar updateProgress;
    Spinner spinner, currentSetSpinner;
    LinearLayout currentSetLL;
    static Boolean newM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_non_racquet);

        final String matchName = getIntent().getStringExtra("matchName");
        final String gender = getIntent().getStringExtra("gender");
        final String header = getIntent().getStringExtra("header");
        newM = getIntent().getBooleanExtra("new", false);
        final String eventname = getIntent().getStringExtra("eventName");
        currentSetLL = findViewById(R.id.currentSetLL);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        eventName = findViewById(R.id.eventName);
        venue = findViewById(R.id.venue);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        result = findViewById(R.id.result);
        update = findViewById(R.id.update);
        updateProgress = findViewById(R.id.progressBarNonRacket);
        updateProgress.setVisibility(View.GONE);
        spinner = findViewById(R.id.spinner);
        description = findViewById(R.id.dis);
        info = findViewById(R.id.addinfo);
        currentSetSpinner = findViewById(R.id.currentSetSpinner);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AdminNonRacketMatch.TimePickerFragment().show(getSupportFragmentManager(), "timePicker");
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AdminNonRacketMatch.DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(Arrays.asList("LIVE", "PAST")));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(Arrays.asList("Team 1", "Team 2")));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currentSetSpinner.setAdapter(adapter1);

        DatabaseReference match = FirebaseDatabase.getInstance().getReference().child(header).child(gender).child("match").child(matchName);

        if (! header.equals("Cricket")) {
            currentSetLL.setVisibility(View.GONE);
        }

        if (newM) {
            HashMap<String, String> dataMap = new HashMap<>();
            dataMap.put("team1", "");
            dataMap.put("team2", "");
            dataMap.put("eventName", eventname);
            dataMap.put("result", "");
            dataMap.put("venue", "");
            dataMap.put("date", "Select Date");
            dataMap.put("time", "Select Time");
            dataMap.put("team1_score", "");
            dataMap.put("team2_score", "");
            dataMap.put("when", "");
            dataMap.put("type", "");
            dataMap.put("extra_info_left", "");
            match.setValue(dataMap);
        }


        match.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                result.setText(dataSnapshot.child("result").getValue().toString());
                venue.setText(dataSnapshot.child("venue").getValue().toString());
                date.setText(dataSnapshot.child("date").getValue().toString());
                time.setText(dataSnapshot.child("time").getValue().toString());
                if (header.equals("Cricket")) {
                    String team1N = dataSnapshot.child("team1").getValue().toString();
                    String team2N = dataSnapshot.child("team2").getValue().toString();
                    if (team1N.length() > 1) {
                        if (team1N.charAt(team1N.length() - 1) == '*') {
                            team1.setText(team1N.substring(0, team1N.length() - 1));
                            team2.setText(team2N);
                        }
                    }
                    if (team2N.length() > 1) {
                        if (team2N.charAt(team2N.length() - 1) == '*') {
                            team1.setText(team1N);
                            team2.setText(team2N.substring(0, team2N.length() - 1));
                        }
                    }
                } else {
                    team1.setText(dataSnapshot.child("team1").getValue().toString());
                    team2.setText(dataSnapshot.child("team2").getValue().toString());
                }
                score1.setText(dataSnapshot.child("team1_score").getValue().toString());
                score2.setText(dataSnapshot.child("team2_score").getValue().toString());
                description.setText(dataSnapshot.child("type").getValue().toString());
                info.setText(dataSnapshot.child("extra_info_left").getValue().toString().trim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                    Toast.makeText(AdminNonRacketMatch.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                } else {
                    updateProgress.setVisibility(View.VISIBLE);
                    DatabaseReference match = FirebaseDatabase.getInstance().getReference().child(header).child(gender).child("match").child(matchName);
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (header.equals("Cricket")) {
                        if (currentSetSpinner.getSelectedItemPosition() == 0) {
                            hashMap.put("team1", team1.getText().toString() + "*");
                            hashMap.put("team2", team2.getText().toString());
                        } else {
                            hashMap.put("team1", team1.getText().toString());
                            hashMap.put("team2", team2.getText().toString() + "*");
                        }
                    } else {
                        hashMap.put("team1", team1.getText().toString());
                        hashMap.put("team2", team2.getText().toString());
                    }
                    hashMap.put("eventName", eventName.getText().toString());
                    hashMap.put("result", result.getText().toString());
                    hashMap.put("venue", venue.getText().toString());
                    hashMap.put("date", date.getText().toString());
                    hashMap.put("time", time.getText().toString());
                    hashMap.put("team1_score", score1.getText().toString());
                    hashMap.put("team2_score", score2.getText().toString());
                    hashMap.put("when", spinner.getSelectedItem().toString().toLowerCase());
                    hashMap.put("type", description.getText().toString());
                    hashMap.put("extra_info_left", "\t\t" + info.getText().toString());

                    match.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(AdminNonRacketMatch.this, "Data updated!", Toast.LENGTH_SHORT).show();
                                updateProgress.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(AdminNonRacketMatch.this, "Error!Please try again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }



        });
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
