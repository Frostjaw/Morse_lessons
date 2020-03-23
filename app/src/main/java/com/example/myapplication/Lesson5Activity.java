package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson5Activity extends LessonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        super.launchBottomNavigation();
    }

    @Override
    public void openLearning(View view){
        Intent intent = new Intent(this, Lesson5LearningActivity.class);
        startActivity(intent);
    }

    @Override
    public void openReception(View view){
        Intent intent = new Intent(this, Lesson5ReceptionActivity.class);
        startActivity(intent);
    }

    @Override
    public void openTransmission(View view){
        Intent intent = new Intent(this, Lesson5TransmissionActivity.class);
        startActivity(intent);
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson6Activity.class);
        startActivity(intent);
    }
}
