package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class Lesson8TransmissionActivity extends LessonTransmissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8_transmission);

        launchActivity();
        lowerCharacterBound = 29;
        answerTextView = findViewById(R.id.answerTextView);
        characterTextView = findViewById(R.id.characterTextView);
        checker = new Checker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.keyButton);
        setListenerOnTapperButton();
    }

    @Override
    public void startTransmission(View view){
        // очищаем надпись о предыдущей букве
        answerTextView.setText("");

        Random random = new Random();
        curCharacter = random.nextInt(3) + lowerCharacterBound;
        characterTextView.setText(morseCodeGenerator.morseDictionary.get(curCharacter));
    }

    @Override
    public void next(View view) {
        Intent intent = new Intent(this, Lesson9Activity.class);
        startActivity(intent);
    }
}
