package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TrainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
    }

    public void openReceptionTrainer(View view){
        Intent intent = new Intent(this, ReceptionTrainerActivity.class);
        startActivity(intent);
    }

    public void openTransmissionTrainer(View view){
        Intent intent = new Intent(this, TransmissionTrainerActivity.class);
        startActivity(intent);
    }
}
