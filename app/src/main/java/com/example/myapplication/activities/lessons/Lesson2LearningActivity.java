package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson2LearningActivity extends LessonLearningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play5();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play6();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play7();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play8();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson2ReceptionActivity.class);
        startActivity(intent);
    }
}
