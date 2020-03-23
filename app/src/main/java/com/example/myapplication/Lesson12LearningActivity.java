package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson12LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12_learning);

        launchActivity();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play50();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play51();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play52();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play53();
    }

    @Override
    public void play5(View view){
        morseCodeGenerator.play54();
    }

    @Override
    public void play6(View view){
        morseCodeGenerator.play55();
    }

    @Override
    public void play7(View view){
        morseCodeGenerator.play56();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson12ReceptionActivity.class);
        startActivity(intent);
    }
}
