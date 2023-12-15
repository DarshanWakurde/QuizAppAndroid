package com.example.quizappdemo;


import static com.example.quizappdemo.StartActivity.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.io.DataInput;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class MainActivity extends AppCompatActivity {

    String name;


    LinearProgressIndicator materialProgressBar;
    Button diaBtn,NextBtton,End;
    TextView question, option1,option2,option3,option4;
    CardView option1View,option2View,option3View,option4View;
    DataModel dataModel;
    static int correctCount;
    static int notAttemp;
    static int wrongCount;

    CountDownTimer timer;
    int timerValue=20;
    static int index=0;
    Dialog dialog;
    List<DataModel> AnsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        materialProgressBar=findViewById(R.id.progress);
        question=findViewById(R.id.QuestionText);
        option1=findViewById(R.id.option1Text);
        option2=findViewById(R.id.option2Text);
        option3=findViewById(R.id.option3Text);
        option4=findViewById(R.id.option4Text);
        Random rand = new Random();
        dialog=new Dialog(MainActivity.this);
        option1View=findViewById(R.id.option1);
        option2View=findViewById(R.id.Option2);
        option3View=findViewById(R.id.Option3); option4View=findViewById(R.id.Option4);

        End =findViewById(R.id.endGame);




        Collections.shuffle(list);

        AnsData=list;

        dataModel=AnsData.get(index);
        setData();








        Intent intent=getIntent();
        name=intent.getStringExtra("Name");





        option1View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "okkClick", Toast.LENGTH_SHORT).show();
                if(dataModel.getOptiona().equals(dataModel.getAnswer())){
                    Toast.makeText(MainActivity.this, "okkClick5555", Toast.LENGTH_SHORT).show();
                    option1.setBackgroundColor(getResources().getColor(R.color.green));

                    option4View.setClickable(false);
                    option2View.setClickable(false);
                    option3View.setClickable(false);

                    Correct();
                }
                else {
                    option1.setBackgroundColor(getResources().getColor(R.color.timesup));

                    wrongCount(option1View);
                }
            }
        });



        option2View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "option 2", Toast.LENGTH_SHORT).show();
                if(dataModel.getOptionb().equals(dataModel.getAnswer())){
                    Toast.makeText(MainActivity.this, "option 22222", Toast.LENGTH_SHORT).show();
                    option2.setBackgroundColor(getResources().getColor(R.color.green));
                    option1View.setClickable(false);
                    option4View.setClickable(false);
                    option3View.setClickable(false);
                    Correct();
                }
                else {
                    option2.setBackgroundColor(getResources().getColor(R.color.timesup));

                    wrongCount(option1View);
                }
            }
        });



        option3View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "option3", Toast.LENGTH_SHORT).show();
                if(dataModel.getOptionc().equals(dataModel.getAnswer())){
                    Toast.makeText(MainActivity.this, "option3333", Toast.LENGTH_SHORT).show();
                    option3.setBackgroundColor(getResources().getColor(R.color.green));
                    option1View.setClickable(false);
                    option2View.setClickable(false);
                    option4View.setClickable(false);
                    Correct();
                }
                else {
                    option3.setBackgroundColor(getResources().getColor(R.color.timesup));

                    wrongCount(option1View);
                }
            }
        });


        option4View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "option4", Toast.LENGTH_SHORT).show();
                if(dataModel.getOptiond().equals(dataModel.getAnswer())){
                    Toast.makeText(MainActivity.this, "option444", Toast.LENGTH_SHORT).show();
                    option4.setBackgroundColor(getResources().getColor(R.color.green));
                    option1View.setClickable(false);
                    option2View.setClickable(false);
                    option3View.setClickable(false);
                    Correct();
                }
                else {
                    option4.setBackgroundColor(getResources().getColor(R.color.timesup));
                    wrongCount(option1View);
                }
            }
        });




        timerIsHere();





        NextBtton=findViewById(R.id.NextActivity);
        End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameWon();
            }
        });



    }

    private void setData() {

        if(index==15){
            End.setVisibility(View.VISIBLE);
        }

        unAbleButton();
        question.setText(dataModel.getQuestion());
        option1.setText(dataModel.getOptiona());
        option2.setText(dataModel.getOptionb());
        option3.setText(dataModel.getOptionc());
        option4.setText(dataModel.getOptiond());

    }

    public void Correct(){
        NextBtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index<15) {
                    correctCount++;
                    index++;
                    dataModel = list.get(index);
                    timer.cancel();
                    timerValue = 20;
                    timerIsHere();
                    resetColor();
                    setData();
                }
                else {
                    gameWon();
                }
            }

        });

    }
    public void wrongCount(CardView cardView){

        NextBtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<15){
                    wrongCount++;
                    index++;
                    dataModel=list.get(index);
                    timer.cancel();
                    timerValue=20;
                    timerIsHere();
                    resetColor();

                    setData();
                }
                else {
                    gameWon();
                }
            }
        });

    }


    public void notAttepted(){

        dialog.hide();
        if(index<15){
            notAttemp++;
            index++;
            dataModel=list.get(index);
            timerValue = 20;
            timer.cancel();
            timerIsHere();
            resetColor();
            setData();
        }
        else {
            gameWon();
        }
    }




    private void gameWon() {
        Intent nextInent=new Intent(MainActivity.this,WonActivity.class);
        nextInent.putExtra("Correct",correctCount);
        nextInent.putExtra("Wrong",wrongCount);
        nextInent.putExtra("NotAttemt",notAttemp);
        Intent nex=getIntent();
        nextInent.putExtra("Resid",nex.getIntExtra("Resid",R.drawable.java));
        nextInent.putExtra("Name",name);
        Toast.makeText(this, ""+wrongCount, Toast.LENGTH_SHORT).show();
        startActivity(nextInent);
        finish();
    }

    public void unAbleButton(){

        option1View.setClickable(true);
        option2View.setClickable(true);
        option3View.setClickable(true);
        option4View.setClickable(true);

    }

    public void  disableButton(){
        option1View.setClickable(false);
        option2View.setClickable(false);
        option3View.setClickable(false);
        option4View.setClickable(false);
    }


    public void resetColor(){
        option1.setBackgroundColor(getResources().getColor(R.color.white));
        option2.setBackgroundColor(getResources().getColor(R.color.white));
        option4.setBackgroundColor(getResources().getColor(R.color.white));
        option3.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void timerIsHere(){
        int maxTime=20000;
        timer=new CountDownTimer(maxTime,1000) {
            @Override
            public void onTick(long l) {
                timerValue-=1;
                materialProgressBar.setProgress(timerValue);

            }

            @Override
            public void onFinish() {

                dialog.setContentView(R.layout.dialoge);
                diaBtn= dialog.findViewById(R.id.nextQuestion);
                diaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        notAttepted();
                    }
                });
                dialog.show();

            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        dialog.cancel();
        list.clear();
        index=0;
        correctCount=0;
        notAttemp=0;
        wrongCount=0;

    }


}