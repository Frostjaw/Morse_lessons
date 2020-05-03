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

    public void openReceptionTrainer(View view){
        Intent intent = new Intent(this, CharacterReceptionTrainerActivity.class);
        startActivity(intent);
    }

    public void openTransmissionTrainer(View view){
        Intent intent = new Intent(this, CharacterTransmissionTrainerActivity.class);
        startActivity(intent);
    }
}
