package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.activities.MyActivity;

import java.util.Random;

public abstract class LessonReceptionActivity extends MyActivity {
    protected int curCharacter;
    protected TextView answerTextView;
    protected int lowerCharacterBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void startReception(View view){
        Random random = new Random();
        curCharacter = random.nextInt(4) + lowerCharacterBound; // 4 - верхняя граница диапазона (0-4)
        morseCodeGenerator.playConcrete(curCharacter);
    }

    public void next(View view){
        Intent intent = new Intent(this, LessonTransmissionActivity.class);
        startActivity(intent);
    }

    public void pressed1(View view){
        if (curCharacter == lowerCharacterBound)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed2(View view){
        if (curCharacter == lowerCharacterBound + 1)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed3(View view){
        if (curCharacter == lowerCharacterBound + 2)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed4(View view){
        if (curCharacter == lowerCharacterBound + 3)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed5(View view){
        if (curCharacter == lowerCharacterBound + 4)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed6(View view){
        if (curCharacter == lowerCharacterBound + 5)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed7(View view){
        if (curCharacter == lowerCharacterBound + 6)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }

    public void pressed8(View view){
        if (curCharacter == lowerCharacterBound + 7)
        {
            answerTextView.setText("Верно");
        }else{
            answerTextView.setText("Неверно");
        }
    }
}
