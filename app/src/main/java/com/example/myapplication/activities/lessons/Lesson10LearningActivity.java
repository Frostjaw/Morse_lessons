package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson10LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10_learning);

        launchActivity();
        super.launchBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play37();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play38();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play39();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play40();
    }

    @Override
    public void play5(View view){
        morseCodeGenerator.play41();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson10ReceptionActivity.class);
        startActivity(intent);
    }
}
