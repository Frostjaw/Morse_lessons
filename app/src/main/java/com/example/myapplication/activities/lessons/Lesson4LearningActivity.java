package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson4LearningActivity extends LessonLearningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play13();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play14();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play15();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play16();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson4ReceptionActivity.class);
        startActivity(intent);
    }
}
