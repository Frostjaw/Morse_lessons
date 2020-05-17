package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson1LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play1();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play2();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play3();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play4();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson1ReceptionActivity.class);
        startActivity(intent);
    }
}
