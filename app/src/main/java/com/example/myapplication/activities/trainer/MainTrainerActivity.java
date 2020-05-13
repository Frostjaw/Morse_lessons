package com.example.myapplication.activities.trainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;

public class MainTrainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
    }

    public void openCharacterReceptionTrainer(View view){
        Intent intent = new Intent(this, CharacterReceptionTrainerActivity.class);
        startActivity(intent);
    }

    public void openCharacterTransmissionTrainer(View view){
        Intent intent = new Intent(this, CharacterTransmissionTrainerActivity.class);
        startActivity(intent);
    }

    public void openTextReceptionTrainer(View view){
        Intent intent = new Intent(this, TextReceptionTrainerActivity.class);
        startActivity(intent);
    }

    public void openTextTransmissionTrainer(View view){
        Intent intent = new Intent(this, TextTransmissionTrainerActivity.class);
        startActivity(intent);
    }

}
