package com.example.borahaequiz;

//import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText entername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entername = findViewById(R.id.entername);

    }
    public void openActivity(View v) {
        if(TextUtils.isEmpty(entername.getText().toString())){

            entername.setError("Enter Valid Name");

            return;
        }
        else {

            Toast.makeText(this, "Let's Go~~ Let's Go~~", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Choose_Your_Bias.class);

            startActivity(intent);
        }

    }



}