package com.example.myapplication.activities.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.activities.SoundActivity;

public abstract class LessonLearningActivity extends SoundActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void play1(View view){

    }

    public void play2(View view){

    }

    public void play3(View view){

    }

    public void play4(View view){

    }

    public void play5(View view){

    }

    public void play6(View view){

    }

    public void play7(View view){

    }

    public void play8(View view){

    }

    public void next(View view){
        Intent intent = new Intent(this, LessonReceptionActivity.class);
        startActivity(intent);
    }
}
