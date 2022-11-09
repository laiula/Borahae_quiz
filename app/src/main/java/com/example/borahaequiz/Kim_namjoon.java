package com.example.borahaequiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Kim_namjoon extends AppCompatActivity {
    private TextView countLabel, questionLabel;
    private Button option1, option2, option3, option4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;
    private MediaPlayer mediaPlayer;


    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    String quizData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"What does BTS stands for ?", "All the given option", "BangTan Sonyeondan", "Beyond The Scene", "Bulletproof Boy Scouts"},
            {"What is the debut date of BTS ?", "12-Jun-2013", "12-Jul-2013", "9-Jun-2013", "9-Jul-2013"},
            {"'Forever Rain' is a song by which BTS member ? ", "RM", "AgustD", "Jhope", "V"},
            {"Who was the last member to join BTS ?", "Jimin", "Taehyung", "Jungkook", "RM"},
            {"For which song BTS achieved their first win on a South Korean Music Show ?", "I Need you", "Run", "No more Dream", "Dope"},
            {"Which BTS member spent his teen years in Australia as an Exchange student ?", "Jin", "RM", "Jungkook", "V"},
            {"Which BTS member is fluent Japanese speaker ?", "Taehyung", "Jungkook", "Suga", "Jimin"},
            {"From the following Artist, with which Artist BTS haven't collaborated yet ?", "Olivia", "ColdPlay", "Halsey", "Steve Aoki"},
            {"In Which year BTS performed in USA for the first time ? ", "2014", "2013", "2015", "2016"},
            {"A BTS member Suga wrote a song 'first love', Who was his first love according to the song ?", "Piano", "Guitar", "His MOM", "His Crush"},
            {"Which BTS song hits 1 Billion views first ?", "DNA", "Fake Love", "Dynamite", "Butter"},
            {"Who is known as 'Rock Bison' in BTS ?", "MOCHI", "TAETAE", "SAVAGE CAT", "WWH"},
            {"Who loves HamBurger and Sprite and hate snakeu from BTS ?", "Hoseok", "Seokjin", "Namjoon", "Jungkook"},
            {"Who is the biggest Fanboy of IU ?", "Kookie", "namjoonie", "Yoongles", "Hobi"},
            {"Who plays best basket ball among BTS ?", "AgustD", "Jimin", "Taehyung", "Jin"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kim_namjoon);
        mediaPlayer = MediaPlayer.create(Kim_namjoon.this,R.raw.pied_piper);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        countLabel = findViewById(R.id.countLabel);
        questionLabel = findViewById(R.id.questionLabel);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);
        Log.v("CATEGORY", quizCategory + "");


        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Country
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    private void showNextQuiz() {
        // Update quizCountLabel.
        countLabel.setText("Q" + quizCount);

        // Generate random number between 0 and 14 (quizArray's size - 1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        option1.setText(quiz.get(0));
        option2.setText(quiz.get(1));
        option3.setText(quiz.get(2));
        option4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);
    }
    public void checkAnswer(View view){
        //get pushed Button
        Button option = (Button) findViewById(view.getId());
        String btnText = option.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            //correct !
            alertTitle = "Correct Answer ARMY";
            rightAnswerCount++;
        } else {
            alertTitle = "Wrong Answer ARMY";
        }
        //create dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer:" +rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT){
                    mediaPlayer.release();
                    Intent intent = new Intent(getApplicationContext(),result.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                    startActivity(intent);

                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}