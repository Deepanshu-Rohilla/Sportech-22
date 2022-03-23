package com.sportech20.iitd.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sportech20.iitd.R;

public class AdminLogin extends AppCompatActivity {

    EditText email,pwd;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();

        email = findViewById(R.id.editText);
        pwd = findViewById(R.id.editText2);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty() || pwd.getText().toString().isEmpty()) {
                    Toast.makeText(AdminLogin.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else{

                    progressBar.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), pwd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(AdminLogin.this,AdminActivity.class));
                            progressBar.setVisibility(View.INVISIBLE);
                        } else {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(AdminLogin.this, "Invalid login credentials!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            }
        });


    }
}
