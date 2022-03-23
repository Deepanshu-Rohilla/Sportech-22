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

public class AthleticsAdmin extends AppCompatActivity {
    ProgressBar progressBar;
    static Button date, time;
    Button update;
    EditText winner, rup1, rup2, rup3, eventName, venue, score1, score2, score3, score4, type;
    Spinner spinner;
    static Boolean newM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics__admin);

        progressBar = findViewById(R.id.updateProgress);
        progressBar.setVisibility(View.INVISIBLE);
        winner = findViewById(R.id.winner);
        rup1 = findViewById(R.id.rup1);
        rup2 = findViewById(R.id.rup2);
        rup3 = findViewById(R.id.rup3);
        eventName = findViewById(R.id.eventName);
        score1 = findViewById(R.id.player1score);
        score2 = findViewById(R.id.player2score);
        score3 = findViewById(R.id.player3score);
        score4 = findViewById(R.id.player4score);
        venue = findViewById(R.id.venue);
        update = findViewById(R.id.update);
        type = findViewById(R.id.dis_in);
        spinner = findViewById(R.id.status);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        final String gender = getIntent().getStringExtra("gender");
        final String matchName = getIntent().getStringExtra("matchName");
        newM = getIntent().getBooleanExtra("new", false);
        final String eventname = getIntent().getStringExtra("eventName");

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerFragment().show(getSupportFragmentManager(), "timePicker");
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(Arrays.asList("LIVE", "PAST")));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        DatabaseReference athi_match = FirebaseDatabase.getInstance().getReference().child("Athletics").child(gender).child("match").child(matchName);

        if (newM){
            HashMap<String, String> dataMap = new HashMap<>();
            dataMap.put("winner", "");
            dataMap.put("runner_up", "");
            dataMap.put("runner_up2", "");
            dataMap.put("runner_up3","");
            dataMap.put("team1_score","");
            dataMap.put("team2_score","");
            dataMap.put("team3_score","");
            dataMap.put("team4_score","");
            dataMap.put("venue", "");
            dataMap.put("eventName", eventname);
            dataMap.put("when","");
            dataMap.put("date", "Select Date");
            dataMap.put("time", "Select Time");
            athi_match.setValue(dataMap);
        }

        athi_match.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                winner.setText(dataSnapshot.child("winner").getValue().toString());
                rup1.setText(dataSnapshot.child("runner_up").getValue().toString());
                eventName.setText(dataSnapshot.child("eventName").getValue().toString());
                rup2.setText(dataSnapshot.child("runner_up2").getValue().toString());
                venue.setText(dataSnapshot.child("venue").getValue().toString());
                rup3.setText(dataSnapshot.child("runner_up3").getValue().toString());
                score1.setText(dataSnapshot.child("team1_score").getValue().toString());
                score2.setText(dataSnapshot.child("team2_score").getValue().toString());
                score3.setText(dataSnapshot.child("team3_score").getValue().toString());
                score4.setText(dataSnapshot.child("team4_score").getValue().toString());
                date.setText(dataSnapshot.child("date").getValue().toString());
                time.setText(dataSnapshot.child("time").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date.getText().toString().equals("Select Date") || time.getText().toString().equals("Select Time")) {
                    Toast.makeText(AthleticsAdmin.this, "One of date or time is not entered", Toast.LENGTH_SHORT).show();
                } else {
                    progressBar.setVisibility(View.VISIBLE);

                    DatabaseReference athi_match = FirebaseDatabase.getInstance().getReference().child("Athletics").child(gender).child("match").child(matchName);
                    HashMap<String, String> dataMap = new HashMap<>();

                    dataMap.put("winner", winner.getText().toString());
                    dataMap.put("runner_up", rup1.getText().toString());
                    dataMap.put("runner_up2", rup2.getText().toString());
                    dataMap.put("runner_up3", rup3.getText().toString());
                    dataMap.put("team1_score", score1.getText().toString());
                    dataMap.put("team2_score", score2.getText().toString());
                    dataMap.put("team3_score", score3.getText().toString());
                    dataMap.put("team4_score", score4.getText().toString());
                    dataMap.put("venue", venue.getText().toString());
                    dataMap.put("eventName", eventName.getText().toString());
                    dataMap.put("when", spinner.getSelectedItem().toString().toLowerCase());
                    dataMap.put("date", date.getText().toString());
                    dataMap.put("time", time.getText().toString());
                    athi_match.setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(AthleticsAdmin.this, "Data updated!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.INVISIBLE);
                            } else {
                                Toast.makeText(AthleticsAdmin.this, "Error!Please try again!", Toast.LENGTH_SHORT).show();
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