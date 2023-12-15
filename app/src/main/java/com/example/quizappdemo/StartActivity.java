package com.example.quizappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.loadinganimation.LoadingAnimation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    LoadingAnimation loadingAnim;

    public static ArrayList<DataModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);







            loadingAnim=findViewById(R.id.loadingAnimNext2);
            loadingAnim.setProgressVector(getResources().getDrawable(R.drawable.quiz));
            loadingAnim.setTextViewVisibility(true);
            loadingAnim.setTextStyle(true);
            loadingAnim.setTextColor(R.color.background);
            loadingAnim.setTextSize(12F);
            loadingAnim.setTextMsg("Please Wait");
            loadingAnim.setEnlarge(5);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            list = new ArrayList<>();
//            ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
//            Sprite doubleBounce = new Wave();
//            progressBar.setIndeterminateDrawable(doubleBounce);
            Intent inet = getIntent();
            String name = inet.getStringExtra("Name");


            if (name.equals("Python")) {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                myRef.child("Python questions").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            DataModel dataModel = data.getValue(DataModel.class);

                            Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                            list.add(dataModel);


                            if (list.size() == 25) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        Intent intent=new Intent(StartActivity.this, MainActivity.class);
                                        intent.putExtra("Name",name);
                                        Intent nextIntent=getIntent();
                                        intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 2000);
                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }


            if (name.equals("Java Programing")) {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                myRef.child("java questions").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            DataModel dataModel = data.getValue(DataModel.class);

                            Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                            list.add(dataModel);


                            if (list.size() == 25) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent=new Intent(StartActivity.this, MainActivity.class);
                                        intent.putExtra("Name",name);
                                        Intent nextIntent=getIntent();
                                        intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 2000);
                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }




            if (name.equals("Data Structure and algo")) {

                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                myRef.child("DSA questions").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            DataModel dataModel = data.getValue(DataModel.class);

                            Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                            list.add(dataModel);
                            if (list.size() == 25) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent=new Intent(StartActivity.this, MainActivity.class);
                                        intent.putExtra("Name",name);
                                        Intent nextIntent=getIntent();
                                        intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 2000);
                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }




            if (name.equals("Sql")) {

                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                myRef.child("Sql questions").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            DataModel dataModel = data.getValue(DataModel.class);

                            Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                            list.add(dataModel);
                            if (list.size() == 25) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent=new Intent(StartActivity.this, MainActivity.class);
                                        intent.putExtra("Name",name);
                                        Intent nextIntent=getIntent();
                                        intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 2000);
                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }



            if (name.equals("Operating System")) {

                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                myRef.child("Os questions").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {

                            DataModel dataModel = data.getValue(DataModel.class);

                            Log.d("String", dataModel.getQuestion() + "--" + dataModel.getQuestion() + "--" + dataModel.getAnswer() + "--" + dataModel.getOptionb() + "--" + dataModel.getOptionc() + "--" + dataModel.getOptiond());
                            list.add(dataModel);
                            if (list.size() == 25) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent=new Intent(StartActivity.this, MainActivity.class);
                                        intent.putExtra("Name",name);
                                        Intent nextIntent=getIntent();
                                        intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 2000);
                            }


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }






        }
}