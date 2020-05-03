package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

import java.util.Random;

public class Lesson9ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_reception);

        launchActivity();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 32;
    }

    @Override
    public void startReception(View view){
        Random random = new Random();
        curCharacter = random.nextInt(5) + lowerCharacterBound; // 5 - верхняя граница диапазона (0-5)
        morseCodeGenerator.playConcrete(curCharacter);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson9TransmissionActivity.class);
        startActivity(intent);
    }
}
