package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.utils.TransmissionChecker;
import com.example.myapplication.R;

import java.util.Random;

public class Lesson9TransmissionActivity extends LessonTransmissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9_transmission);

        launchActivityWithBottomNavigation();
        lowerCharacterBound = 32;
        answerTextView = findViewById(R.id.answerTextView);
        characterTextView = findViewById(R.id.characterTextView);
        transmissionChecker = new TransmissionChecker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.keyButton);
        setListenerOnTapperButton();
    }

    @Override
    public void startTransmission(View view){
        // очищаем надпись о предыдущей букве
        answerTextView.setText("");

        Random random = new Random();
        curCharacter = random.nextInt(5) + lowerCharacterBound;
        characterTextView.setText(morseCodeGenerator.morseDictionary.get(curCharacter));
    }

    @Override
    public void next(View view) {
        Intent intent = new Intent(this, Lesson10Activity.class);
        startActivity(intent);
    }
}
