package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson3LearningActivity extends LessonLearningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_learning);

        launchActivity();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play9();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play10();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play11();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play12();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson3ReceptionActivity.class);
        startActivity(intent);
    }
}
