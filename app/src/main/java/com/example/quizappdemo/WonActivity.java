package com.example.quizappdemo;



import static com.example.quizappdemo.StartActivity.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loadinganimation.LoadingAnimation;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class WonActivity extends AppCompatActivity {


    TextView correct,wrong;

    PieChart pieChart;
    public int  corr;
    public int Wrong;
    public  int NotAttept;
    List<PieEntry> lis;
    LoadingAnimation loadingAnim;

    Button Exit,Restart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);


        loadingAnim=findViewById(R.id.celebration);
        loadingAnim.setProgressVector(getResources().getDrawable(R.drawable.trophygif));
        loadingAnim.setTextViewVisibility(true);
        loadingAnim.setTextStyle(true);
        loadingAnim.setTextColor(R.color.background);
        loadingAnim.setTextSize(12F);
        loadingAnim.setTextMsg("");
        loadingAnim.setEnlarge(5);

        pieChart=findViewById(R.id.char11);
        Exit=findViewById(R.id.ExitQuiz);
        Restart=findViewById(R.id.RestartQuiz);


        Intent intent=getIntent();
        corr=intent.getIntExtra("Correct",0);
        Wrong=intent.getIntExtra("Wrong",0);
        NotAttept=intent.getIntExtra("NotAttemt",0);
        correct=findViewById(R.id.corrext);
        wrong=findViewById(R.id.wrong);
        lis=new ArrayList<>();
        correct.setText(" "+corr);
        wrong.setText(" "+Wrong);









        setValue();
        setUpChart();
        Intent intent1=getIntent();

        String name=intent1.getStringExtra("Name");

//        if(name.equals("Data Structure and algo")){
//            long a=databaseHelper.insertData(corr,Wrong);
//            if(a==-1){
//                Toast.makeText(this, "Insertion Gadbad bhai Bhai", Toast.LENGTH_SHORT).show();
//            }
//            else {
//                Toast.makeText(this, "Insert hOgaya", Toast.LENGTH_SHORT).show();
//            }
//        }







        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(WonActivity.this, SelectQuizSubject.class);
                intent.putExtra("Name",name);
                startActivity(intent);
                finish();
            }
        });
        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                Intent intent=new Intent(WonActivity.this, StartActivity.class);
                intent.putExtra("Name",name);
                Intent nextIntent=getIntent();
                intent.putExtra("Resid",nextIntent.getIntExtra("Resid",R.drawable.java));
                startActivity(intent);
                finish();
            }
        });


    }
    private void setUpChart() {
        PieDataSet pieDataSet=new PieDataSet(lis,"");
        PieData pieData=new PieData(pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(getResources().getColor(R.color.white));
        pieData.setValueTextSize(12f);
        pieChart.setData(pieData);

        pieChart.invalidate();

    }

    private void setValue() {
        lis.add(new PieEntry(corr,"Correct"));
        lis.add(new PieEntry(Wrong,"Worng"));
        lis.add(new PieEntry(NotAttept,"NotAttempt"));
    }
}