package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public abstract class LessonActivity extends MyActivity {

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
