package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson6LearningActivity extends LessonLearningActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play21();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play22();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play23();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play24();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson6ReceptionActivity.class);
        startActivity(intent);
    }
}
