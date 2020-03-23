package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
        Intent intent = new Intent(this, NavigationActivity.class);
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
        Intent intent = new Intent(this, TrainerActivity.class);
        startActivity(intent);
    }
}
