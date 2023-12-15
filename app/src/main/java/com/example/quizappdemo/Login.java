package com.example.quizappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText email,password;
    TextView signup;

    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email=findViewById(R.id.editTextUsernamelog);
        password=findViewById(R.id.editTextPasswordlog);


        signup=findViewById(R.id.tvSignup);

        firebaseAuth=FirebaseAuth.getInstance();
        Button btn=findViewById(R.id.btnLogin);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                        startActivity(new Intent(Login.this,SelectQuizSubject.class));

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "please Check email and password", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Login.this,Register.class));

            }
        });



    }
}