package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.activities.SoundActivity;

public abstract class LessonActivity extends SoundActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void openLearning(View view){
        Intent intent = new Intent(this, LessonLearningActivity.class);
        startActivity(intent);
    }

    public void openReception(View view){
        Intent intent = new Intent(this, LessonReceptionActivity.class);
        startActivity(intent);
    }

    public void openTransmission(View view){
        Intent intent = new Intent(this, LessonTransmissionActivity.class);
        startActivity(intent);
    }

    public void next(View view){
        Intent intent = new Intent(this, LessonActivity.class);
        startActivity(intent);
    }
}
