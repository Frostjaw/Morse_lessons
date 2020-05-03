package com.example.myapplication.activities.lessons;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.activities.trainer.TrainerActivity;
import com.example.myapplication.utils.Checker;

import java.util.Random;

public abstract class LessonTransmissionActivity extends TrainerActivity {
    protected int curCharacter;
    protected Checker checker;
    protected TextView answerTextView;
    protected TextView characterTextView;
    protected Button tapperButton;
    protected int lowerCharacterBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ClickableViewAccessibility")
    protected void setListenerOnTapperButton(){
        tapperButton.setOnTouchListener(new View.OnTouchListener() {
            long startTime = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    startTime = System.currentTimeMillis();
                    morseCodeGenerator.start();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    long totalTime = System.currentTimeMillis() - startTime;
                    if ((totalTime > 0) && (totalTime < 250)){ // погрешность
                        if (curCharacter != 0) {
                            checker.check(curCharacter, 0);
                        }
                    }else if((totalTime > 300) && (totalTime < 1000)){
                        if (curCharacter != 0) checker.check(curCharacter,1);
                    } else {
                        answerTextView.setText("Неверно");
                    }
                    morseCodeGenerator.stop();
                }
                return true;
            }
        });
    }

    public void startTransmission(View view){
        // очищаем надпись о предыдущей букве
        answerTextView.setText("");

        Random random = new Random();
        curCharacter = random.nextInt(4) + lowerCharacterBound;
        characterTextView.setText(morseCodeGenerator.morseDictionary.get(curCharacter));
    }

    public void next(View view) {
        Intent intent = new Intent(this, LessonActivity.class);
        startActivity(intent);
    }
}
