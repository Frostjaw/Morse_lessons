package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lesson2TransmissionActivity extends LessonTransmissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_transmission);

        launchActivity();
        lowerCharacterBound = 5;
        answerTextView = findViewById(R.id.answerTextView);
        characterTextView = findViewById(R.id.characterTextView);
        checker = new Checker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.keyButton);
        setListenerOnTapperButton();
    }

    @Override
    public void next(View view) {
        Intent intent = new Intent(this, Lesson3Activity.class);
        startActivity(intent);
    }
}
