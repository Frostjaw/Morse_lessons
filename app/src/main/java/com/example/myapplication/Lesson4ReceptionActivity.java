package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson4ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_reception);

        launchActivity();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 13;
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson4TransmissionActivity.class);
        startActivity(intent);
    }
}
