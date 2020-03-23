package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    private TextView textViewFreq;
    private TextView textViewDotDuration;
    private SeekBar seekBarFreq;
    private SeekBar seekBarDotDuration;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = getSharedPreferences("userSettings", MODE_PRIVATE);

        // frequency
        textViewFreq = findViewById(R.id.frequencyTextView);
        textViewFreq.setText(String.valueOf(settings.getInt("Frequency",1000))); // default 1000
        seekBarFreq = findViewById(R.id.seekBar);
        seekBarFreq.setProgress((settings.getInt("Frequency",0)-1000)/100);
        seekBarFreq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int curFreq = (progress*100) + 1000;
                textViewFreq.setText(String.valueOf(curFreq));
                SharedPreferences.Editor prefEditor = settings.edit();
                prefEditor.putInt("Frequency", curFreq);
                prefEditor.apply();

                MorseCodeGenerator.getMorseCodeGenerator().setFrequency(curFreq);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //dot duration
        textViewDotDuration = findViewById(R.id.dotDurationTextView);
        textViewDotDuration.setText(String.valueOf(settings.getInt("DotDuration",150))); // default 150
        seekBarDotDuration = findViewById(R.id.seekBar2);
        seekBarDotDuration.setProgress((settings.getInt("DotDuration",0)-150)/50);
        seekBarDotDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                int curDotDuration = (progress*50) + 150;
                textViewDotDuration.setText(String.valueOf(curDotDuration));
                SharedPreferences.Editor prefEditor = settings.edit();
                prefEditor.putInt("DotDuration", curDotDuration);
                prefEditor.apply();

                MorseCodeGenerator.getMorseCodeGenerator().setDotDuration(curDotDuration);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekbar){

            }
        });
    }
}
