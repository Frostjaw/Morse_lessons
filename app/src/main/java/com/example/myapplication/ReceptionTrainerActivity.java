package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;

public class ReceptionTrainerActivity extends MyActivity {

    private DialogFragment chooseCharactersDialog;
    private DialogFragment helpDialog;
    public int curCharacter;
    private TextView answerTextView;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception_trainer);

        launchActivityWithoutNavigation();
        chooseCharactersDialog = new ChooseCharactersDialog();
        helpDialog = new HelpDialog();
        answerTextView = findViewById(R.id.answer_textView);
    }

    public void buttonPressed(View view) {

        if (!morseCodeGenerator.characterPoolIsEmpty){
            String buttonId = getResources().getResourceEntryName(view.getId());
            String temp = buttonId.replaceAll("button_", "");
            int buttonNumber = Integer.parseInt(temp);

            if (curCharacter == buttonNumber) {
                answerTextView.setText("Верно");
            }else{
                answerTextView.setText("Неверно");
            }
        }
    }

    public void showSettingsDialog(View view) {
        chooseCharactersDialog.show(getSupportFragmentManager(), "choose_characters_dialog");
    }

    public void showHelpDialog(View view) {
        if (!morseCodeGenerator.characterPoolIsEmpty) {
            helpDialog.show(getSupportFragmentManager(), "help_dialog");
        }else{
            answerTextView.setText("Выберите символы для тренировки");
        }
    }

    public void startReception(View view){
        if (morseCodeGenerator.characterPoolIsEmpty) {
            answerTextView.setText("Выберите символы для тренировки");
        }else{
            answerTextView.setText("");
            curCharacter = morseCodeGenerator.getAndPlayCharacterFromPool();
        }
    }
}
