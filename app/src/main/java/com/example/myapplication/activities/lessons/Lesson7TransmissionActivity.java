package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.utils.TransmissionChecker;
import com.example.myapplication.R;

public class Lesson7TransmissionActivity extends LessonTransmissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7_transmission);

        launchActivityWithBottomNavigation();
        lowerCharacterBound = 25;
        answerTextView = findViewById(R.id.answerTextView);
        characterTextView = findViewById(R.id.characterTextView);
        transmissionChecker = new TransmissionChecker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.keyButton);
        setListenerOnTapperButton();
    }

    @Override
    public void next(View view) {
        Intent intent = new Intent(this, Lesson8Activity.class);
        startActivity(intent);
    }
}
