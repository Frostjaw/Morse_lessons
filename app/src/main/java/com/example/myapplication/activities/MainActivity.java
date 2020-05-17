package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.activities.trainer.MainTrainerActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void closeApp(View view) {
        finish();
        System.exit(0);
    }

    // rename???
    public void startLearning(View view){
        Intent intent = new Intent(this, LessonNavigationActivity.class);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openDictionary(View view){
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }

    public void openTrainer(View view){
        Intent intent = new Intent(this, MainTrainerActivity.class);
        startActivity(intent);
    }
}
