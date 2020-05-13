package com.example.myapplication.activities.trainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dialogs.ChooseCharactersDialog;
import com.example.myapplication.dialogs.HelpDialog;

public class CharacterReceptionTrainerActivity extends TrainerActivity
        implements ChooseCharactersDialog.OnCharactersSelectedListener {

    public int curCharacter;
    private TextView answerTextView;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_reception_trainer);

        launchActivityWithoutNavigation();
        answerTextView = findViewById(R.id.answer_textView);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof ChooseCharactersDialog) {
            ChooseCharactersDialog dialog = (ChooseCharactersDialog) fragment;
            dialog.setOnCharactersSelectedListener(this);
        }

        if (fragment instanceof HelpDialog) {
            HelpDialog dialog = (HelpDialog) fragment;
            dialog.curCharacter = this.curCharacter;
        }
    }

    @Override
    public void onCharactersSelected(String[] selectedCharacters) {

        answerTextView.setText("");

        // selectedCharacters[0] - characters without punctuations marks
        // selectedCharacters[1] - punctuations marks

        char[] charArray = selectedCharacters[0].toCharArray();
        morseCodeGenerator.setCharacterPoolForGeneration(charArray);

        char[] punctuationMarksArray = selectedCharacters[1].toCharArray();
        morseCodeGenerator.addPunctuationMarksToPool(punctuationMarksArray);
    }

    public void buttonPressed(View view) {

        if (!morseCodeGenerator.characterPoolIsEmpty){
            String buttonId = getResources().getResourceEntryName(view.getId());
            String buttonIdString = buttonId.replaceAll("button_", "");
            int buttonNumber = Integer.parseInt(buttonIdString);

            if (curCharacter == buttonNumber) {
                answerTextView.setText("Верно");
            }else{
                answerTextView.setText("Неверно");
            }
        } else {
            answerTextView.setText("Выберите символы для тренировки");
        }
    }

    public void showSettingsDialog(View view) {
        openChooseCharactersDialog(view);
    }

    public void showHelpDialog(View view) {
        if (!morseCodeGenerator.characterPoolIsEmpty) {
            openHelpDialog(view);
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

    public void repeatCharacter(View view){
        if (morseCodeGenerator.characterPoolIsEmpty) {
            answerTextView.setText("Выберите символы для тренировки");
        }else{
            answerTextView.setText("");
            morseCodeGenerator.playConcrete(curCharacter);
        }
    }

}
