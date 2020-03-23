package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson9Activity extends LessonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9);

        super.launchBottomNavigation();
    }

    @Override
    public void openLearning(View view){
        Intent intent = new Intent(this, Lesson9LearningActivity.class);
        startActivity(intent);
    }

    @Override
    public void openReception(View view){
        Intent intent = new Intent(this, Lesson9ReceptionActivity.class);
        startActivity(intent);
    }

    @Override
    public void openTransmission(View view){
        Intent intent = new Intent(this, Lesson9TransmissionActivity.class);
        startActivity(intent);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson10Activity.class);
        startActivity(intent);
    }
}
