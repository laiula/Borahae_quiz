package com.example.borahaequiz;

import static android.media.MediaPlayer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
//import android.support.v7.app.AppCompatActivity;


public class Choose_Your_Bias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_bias);

    }




    public void startQuiz(View view) {

        int quizCategory= 0;

        switch( view.getId()) {

            case R.id.jin:
                quizCategory = 1;
                break;
            case R.id.suga:
                quizCategory = 2;
                break;
            case R.id.jhope:
                quizCategory = 3;
                break;
            case R.id.jimin:
                quizCategory = 4;
                break;
            case R.id.v:
                quizCategory = 5;
                break;
            case R.id.jungkook:
                quizCategory = 6;
                break;
            case R.id.bts:
                quizCategory = 7;
                break;
        }
        // Start Quiz
        Intent intent = new Intent(getApplicationContext(), Kim_namjoon.class);
        intent.putExtra("QUIZ_CATEGORY", quizCategory);
        startActivity(intent);
    }
}