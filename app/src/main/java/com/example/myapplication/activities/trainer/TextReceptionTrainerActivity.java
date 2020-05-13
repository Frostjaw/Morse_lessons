package com.example.myapplication.activities.trainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dialogs.ChooseCharactersDialog;
import com.example.myapplication.dialogs.ExtendedChooseCharactersDialog;

public class TextReceptionTrainerActivity extends TrainerActivity
        implements ChooseCharactersDialog.OnCharactersSelectedListener,
        ExtendedChooseCharactersDialog.OnGroupNumberSelectedListener {

    private TextView textTextView;
    private TextView alertTextView;

    private int numberOfGroups = 0;
    private String currentText;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_reception_trainer);

        launchActivityWithoutNavigation();
        textTextView = findViewById(R.id.text_textView);
        textTextView.setMovementMethod(new ScrollingMovementMethod());

        alertTextView = findViewById(R.id.alert_textView);

        CheckBox hideCheckBox = findViewById(R.id.hideCheckBox);
        hideCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    hideTextView();
                } else {
                    showTextView();
                }
            }
        });

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof ExtendedChooseCharactersDialog) {
            ExtendedChooseCharactersDialog dialog = (ExtendedChooseCharactersDialog) fragment;
            dialog.setOnCharactersSelectedListener(this);
            dialog.setOnGroupNumberSelectedListener(this);
        }
    }

    @Override
    public void onCharactersSelected(String[] selectedCharacters) {
        textTextView.setText("");

        // selectedCharacters[0] - characters without punctuations marks
        // selectedCharacters[1] - punctuations marks

        char[] charArray = selectedCharacters[0].toCharArray();
        morseCodeGenerator.setCharacterPoolForGeneration(charArray);

        char[] punctuationMarksArray = selectedCharacters[1].toCharArray();
        morseCodeGenerator.addPunctuationMarksToPool(punctuationMarksArray);
    }

    @Override
    public void OnGroupNumberSelected(int numberOfGroups) {

        this.numberOfGroups = numberOfGroups;
    }

    public void showSettingsDialog(View view) {
        openExtendedChooseCharactersDialog(view);
    }

    public void createText(View view) {
        if (morseCodeGenerator.characterPoolIsEmpty) {
            alertTextView.setText("Выберите символы для тренировки");
        }else if (numberOfGroups == 0) {
            alertTextView.setText("Выберите количество групп");
        } else {
            alertTextView.setText("");
            currentText = morseCodeGenerator.generateRandomText(numberOfGroups);

            textTextView.setText(currentText);
        }
    }

    public void startReception(View view){
        if (morseCodeGenerator.characterPoolIsEmpty) {
            alertTextView.setText("Выберите символы для тренировки");
        }else if (numberOfGroups == 0) {
            alertTextView.setText("Выберите количество групп");
        } else {
            alertTextView.setText("");
            morseCodeGenerator.playText(currentText);
        }
    }

    private void hideTextView() {
        textTextView.setText("");
    }

    private void showTextView() {
        textTextView.setText(currentText);
    }

}
