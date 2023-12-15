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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {


    EditText name,email,password,conpass,username;


    FirebaseAuth firebaseAuth;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn=findViewById(R.id.btnSignup);


        login=findViewById(R.id.textView2);
        email=findViewById(R.id.editTextemail);
        password=findViewById(R.id.editTextPassword);
        conpass=findViewById(R.id.editTextConfirmPassword);


        firebaseAuth=FirebaseAuth.getInstance();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString().isEmpty()&&password.getText().toString().isEmpty()){

                    Toast.makeText(Register.this, "Please enter all fields", Toast.LENGTH_SHORT).show();

                }else{
                    if(isValidEmail(email.getText().toString())&&isValidPassword(password.getText().toString())&&password.getText().toString().equals(conpass.getText().toString())){


                        Toast.makeText(Register.this, email.getText().toString()+"==="+password.getText().toString(), Toast.LENGTH_SHORT).show();
                        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(Register.this, "Registerd successfully completed", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this,Login.class));

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this, "Registerd unsuccessfull!!!  or Alredy email present", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                }

            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });



    }


    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        String PASSWORD_REGEX = "^[a-zA-Z1-9]{6,}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}