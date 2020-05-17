package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson11LearningActivity extends LessonLearningActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson11_learning);

        launchActivityWithBottomNavigation();
    }

    @Override
    public void play1(View view){
        morseCodeGenerator.play42();
    }

    @Override
    public void play2(View view){
        morseCodeGenerator.play43();
    }

    @Override
    public void play3(View view){
        morseCodeGenerator.play44();
    }

    @Override
    public void play4(View view){
        morseCodeGenerator.play45();
    }

    @Override
    public void play5(View view){
        morseCodeGenerator.play46();
    }

    @Override
    public void play6(View view){
        morseCodeGenerator.play47();
    }

    @Override
    public void play7(View view){
        morseCodeGenerator.play48();
    }

    @Override
    public void play8(View view){
        morseCodeGenerator.play49();
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson11ReceptionActivity.class);
        startActivity(intent);
    }
}
