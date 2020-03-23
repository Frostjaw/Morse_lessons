package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    public void pressed1(View view){
        Intent intent = new Intent(this, Lesson1Activity.class);
        openLesson(intent);
    }

    public void pressed2(View view){
        Intent intent = new Intent(this, Lesson2Activity.class);
        openLesson(intent);
    }

    public void pressed3(View view){
        Intent intent = new Intent(this, Lesson3Activity.class);
        openLesson(intent);
    }

    public void pressed4(View view){
        Intent intent = new Intent(this, Lesson4Activity.class);
        openLesson(intent);
    }

    public void pressed5(View view){
        Intent intent = new Intent(this, Lesson5Activity.class);
        openLesson(intent);
    }

    public void pressed6(View view){
        Intent intent = new Intent(this, Lesson6Activity.class);
        openLesson(intent);
    }

    public void pressed7(View view){
        Intent intent = new Intent(this, Lesson7Activity.class);
        openLesson(intent);
    }

    public void pressed8(View view){
        Intent intent = new Intent(this, Lesson8Activity.class);
        openLesson(intent);
    }

    public void pressed9(View view){
        Intent intent = new Intent(this, Lesson9Activity.class);
        openLesson(intent);
    }

    public void pressed10(View view){
        Intent intent = new Intent(this, Lesson10Activity.class);
        openLesson(intent);
    }

    public void pressed11(View view){
        Intent intent = new Intent(this, Lesson11Activity.class);
        openLesson(intent);
    }

    public void pressed12(View view){
        Intent intent = new Intent(this, Lesson2Activity.class);
        openLesson(intent);
    }

    public void openLesson(Intent intent){
        startActivity(intent);
    }
}
