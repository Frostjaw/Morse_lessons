package com.example.myapplication.activities.lessons;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.utils.TransmissionChecker;
import com.example.myapplication.R;

import java.util.Random;

public class Lesson12TransmissionActivity extends LessonTransmissionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12_transmission);

        launchActivityWithBottomNavigation();
        lowerCharacterBound = 50;
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
        curCharacter = random.nextInt(7) + lowerCharacterBound;
        characterTextView.setText(morseCodeGenerator.morseDictionary.get(curCharacter));
    }

    @Override
    public void next(View view) {
        //Intent intent = new Intent(this, Lesson12Activity.class);
        //startActivity(intent);
    }
}
