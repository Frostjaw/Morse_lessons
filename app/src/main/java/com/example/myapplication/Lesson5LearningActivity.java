package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson5LearningActivity extends LessonLearningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_learning);

        launchActivity();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play17();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play18();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play19();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play20();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson5ReceptionActivity.class);
        startActivity(intent);
    }
}
