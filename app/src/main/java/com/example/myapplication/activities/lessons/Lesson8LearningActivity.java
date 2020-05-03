package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson8LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_learning);

        launchActivity();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play29();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play30();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play31();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson8ReceptionActivity.class);
        startActivity(intent);
    }
}
