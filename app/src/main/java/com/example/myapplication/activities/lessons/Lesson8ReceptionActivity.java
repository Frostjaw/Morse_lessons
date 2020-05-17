package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

import java.util.Random;

public class Lesson8ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_reception);

        launchActivityWithBottomNavigation();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 29;
    }

    @Override
    public void startReception(View view){
        Random random = new Random();
        curCharacter = random.nextInt(3) + lowerCharacterBound; // 3 - верхняя граница диапазона (0-3)
        morseCodeGenerator.playCharacter(curCharacter);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson8TransmissionActivity.class);
        startActivity(intent);
    }
}
