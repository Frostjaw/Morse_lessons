package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson2ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_reception);

        launchActivityWithBottomNavigation();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 5;
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson2TransmissionActivity.class);
        startActivity(intent);
    }
}
