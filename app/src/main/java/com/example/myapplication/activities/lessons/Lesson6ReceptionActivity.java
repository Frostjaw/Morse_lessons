package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Lesson6ReceptionActivity extends LessonReceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6_reception);

        launchActivityWithBottomNavigation();
        answerTextView = findViewById(R.id.answerTextView);
        lowerCharacterBound = 21;
    }

    @Override
    public void next(View view){
        Intent intent = new Intent(this, Lesson6TransmissionActivity.class);
        startActivity(intent);
    }
}
