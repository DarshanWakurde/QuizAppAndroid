package com.example.quizappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class SelectQuizSubject extends AppCompatActivity {


    CardView english,translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_quiz_subject);


        english=findViewById(R.id.card_learn_english);
        translate=findViewById(R.id.card_translate);
        applySlideInFromLeftAnimation(english);
        applySlideInFromRightAnimation(translate);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectQuizSubject.this,StartActivity.class);
                intent.putExtra("Name","Python");
                startActivity(intent);
                Toast.makeText(SelectQuizSubject.this, "Python", Toast.LENGTH_SHORT).show();
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SelectQuizSubject.this,StartActivity.class);
                intent.putExtra("Name","Java Programing");
                startActivity(intent);
                Toast.makeText(SelectQuizSubject.this, "Java Programing", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void applySlideInFromLeftAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.card);
        view.startAnimation(animation);
    }

    private void applySlideInFromRightAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.card2);
        view.startAnimation(animation);


    }
}