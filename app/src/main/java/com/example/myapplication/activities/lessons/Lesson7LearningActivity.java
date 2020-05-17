package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson7LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play25();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play26();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play27();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play28();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson7ReceptionActivity.class);
        startActivity(intent);
    }
}
