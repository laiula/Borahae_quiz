package com.example.borahaequiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultLabel = findViewById(R.id.resultLabel);
      //  TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences sharedPreferences = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
//        int totalScore = sharedPreferences.getInt("TOTAL_SCORE", 0);
//        totalScore += score;

        resultLabel.setText(score + " /5");
        //totalScoreLabel.setText("Total Score : " + totalScore);

        // Update total score.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //editor.putInt("TOTAL_SCORE", totalScore);
        editor.commit();
    }
    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(),Choose_Your_Bias.class);
        startActivity(intent);
    }
}

