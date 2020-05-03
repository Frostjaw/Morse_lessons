package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

import java.util.Random;

public class Lesson12ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12_reception);

        launchActivity();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 50;
    }

    @Override
    public void startReception(View view){
        Random random = new Random();
        curCharacter = random.nextInt(7) + lowerCharacterBound;
        morseCodeGenerator.playConcrete(curCharacter);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson12TransmissionActivity.class);
        startActivity(intent);
    }
}
