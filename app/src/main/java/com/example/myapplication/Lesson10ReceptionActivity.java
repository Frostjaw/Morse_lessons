package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class Lesson10ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10_reception);

        launchActivity();
        super.launchBottomNavigation();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 37;
    }

    @Override
    public void startReception(View view){
        Random random = new Random();
        curCharacter = random.nextInt(5) + lowerCharacterBound; // 5 - верхняя граница диапазона (0-5)
        morseCodeGenerator.playConcrete(curCharacter);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson10TransmissionActivity.class);
        startActivity(intent);
    }
}
