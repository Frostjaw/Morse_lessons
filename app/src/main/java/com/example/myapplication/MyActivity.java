package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

public abstract class MyActivity extends AppCompatActivity {
    protected Handler handler;
    protected SharedPreferences settings;
    protected int frequency;
    protected int unitOfTime;
    protected MorseCodeGenerator morseCodeGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void launchActivity(){
        handler = new Handler();
        settings = getSharedPreferences("userSettings", MODE_PRIVATE);
        frequency = settings.getInt("Frequency",1000);
        unitOfTime = settings.getInt("DotDuration", 150);
        morseCodeGenerator = MorseCodeGenerator.getMorseCodeGenerator();
        launchBottomNavigation();
    }

    protected void launchActivityWithoutNavigation(){
        handler = new Handler();
        settings = getSharedPreferences("userSettings", MODE_PRIVATE);
        frequency = settings.getInt("Frequency",1000);
        unitOfTime = settings.getInt("DotDuration", 150);
        morseCodeGenerator = MorseCodeGenerator.getMorseCodeGenerator();
    }

    public void launchBottomNavigation(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_navigation:
                            openNavigation();
                            break;
                        case R.id.action_settings:
                            openSettings();
                            break;
                        /*case R.id.action_menu:
                            openMenu();
                            break;*/
                        case R.id.action_dictionary:
                            openDictionary();
                            break;
                    }
                    return false;
                });
    }

    public void openNavigation(){
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /*public void openMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/

    public void openDictionary(){
        Intent intent = new Intent(this, DictionaryActivity.class);
        startActivity(intent);
    }
}
