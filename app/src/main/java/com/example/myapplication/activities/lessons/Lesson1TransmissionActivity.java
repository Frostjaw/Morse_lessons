package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.utils.TransmissionChecker;
import com.example.myapplication.R;

public class Lesson1TransmissionActivity extends LessonTransmissionActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_transmission);

        launchActivityWithBottomNavigation();
        lowerCharacterBound = 1;
        answerTextView = findViewById(R.id.answerTextView);
        characterTextView = findViewById(R.id.characterTextView);
        transmissionChecker = new TransmissionChecker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.keyButton);
        setListenerOnTapperButton();
    }

    @Override
    public void next(View view) {
        Intent intent = new Intent(this, Lesson2Activity.class);
        startActivity(intent);
    }
}
