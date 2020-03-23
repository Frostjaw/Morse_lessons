package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson1ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_reception);

        launchActivity();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 1;
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson1TransmissionActivity.class);
        startActivity(intent);
    }
}
