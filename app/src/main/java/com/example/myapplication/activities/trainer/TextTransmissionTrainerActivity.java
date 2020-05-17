package com.example.myapplication.activities.trainer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dialogs.ChooseCharactersDialog;
import com.example.myapplication.dialogs.TextChooseCharactersDialog;
import com.example.myapplication.utils.TransmissionChecker;

public class TextTransmissionTrainerActivity extends TrainerActivity
        implements ChooseCharactersDialog.OnCharactersSelectedListener,
        TextChooseCharactersDialog.OnGroupNumberSelectedListener {

    protected int curCharacter = 0;
    protected TransmissionChecker transmissionChecker;
    protected TextView answerTextView;
    private TextView textTextView;
    protected Button tapperButton;
    protected int lowerCharacterBound;
    private int numberOfGroups = 0;
    private String currentText;
    private int isCurrentCharFinished = 0;
    private int currentCharIndex;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_transmission_trainer);

        launchActivity();

        answerTextView = findViewById(R.id.answer_textView);
        textTextView = findViewById(R.id.text_textView);
        textTextView.setMovementMethod(new ScrollingMovementMethod());

        transmissionChecker = new TransmissionChecker(answerTextView);
        // Listener для кнопки
        tapperButton = findViewById(R.id.key_button);
        setListenerOnTapperButton();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof TextChooseCharactersDialog) {
            TextChooseCharactersDialog dialog = (TextChooseCharactersDialog) fragment;
            dialog.setOnCharactersSelectedListener(this);
            dialog.setOnGroupNumberSelectedListener(this);
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

    @SuppressLint("ClickableViewAccessibility")
    private void setListenerOnTapperButton(){
        tapperButton.setOnTouchListener(new View.OnTouchListener() {
            long startTime = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    startTime = System.currentTimeMillis();
                    morseCodeGenerator.start();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    long totalTime = System.currentTimeMillis() - startTime;
                    if ((totalTime > 0) && (totalTime < 250)){ // погрешность
                        if (curCharacter != 0) {
                            isCurrentCharFinished = transmissionChecker.checkCharacterInText(curCharacter, 0);
                            if (isCurrentCharFinished == 1) {
                                currentCharIndex++;
                                if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                                    int temp = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                    if (temp != -1) {
                                            curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                            //Log.d(LOG_TAG, String.valueOf(curCharacter));
                                    } else {
                                            currentCharIndex++;
                                            if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                                                curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                            }
                                    }
                                } else {
                                    currentCharIndex = 0;
                                    curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                }
                            }
                        }
                    }else if((totalTime > 300) && (totalTime < 1000)){
                        if (curCharacter != 0) {
                            isCurrentCharFinished = transmissionChecker.checkCharacterInText(curCharacter,1);
                            if (isCurrentCharFinished == 1) {
                                currentCharIndex++;
                                if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                                    int temp = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                    if (temp != -1) {
                                        curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                        //Log.d(LOG_TAG, String.valueOf(curCharacter));
                                    } else {
                                        currentCharIndex++;
                                        if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                                            curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                        }
                                    }
                                } else {
                                    currentCharIndex = 0;
                                    curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                }
                            }
                        }
                    } else {
                        answerTextView.setText("Неверно");
                        currentCharIndex++;
                        if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                            int temp = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                            if (temp != -1) {
                                curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                //Log.d(LOG_TAG, String.valueOf(curCharacter));
                            } else {
                                currentCharIndex++;
                                if (currentCharIndex < morseCodeGenerator.generatedTextIndexes.size()) {
                                    curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                                }
                            }
                        } else {
                            currentCharIndex = 0;
                            curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
                        }
                    }
                    morseCodeGenerator.stop();
                }
                return true;
            }
        });
    }

    @Override
    public void OnGroupNumberSelected(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public void createText(View view) {
        if (morseCodeGenerator.charactersPoolIsEmpty) {
            answerTextView.setText("Выберите символы для тренировки");
        }else if (numberOfGroups == 0) {
            answerTextView.setText("Выберите количество групп");
        } else {
            answerTextView.setText("");
            currentText = morseCodeGenerator.generateRandomText(numberOfGroups);

            textTextView.setText(currentText);
            startListening();
        }
    }

    private void startListening() {
        currentCharIndex = 0;
        curCharacter = morseCodeGenerator.generatedTextIndexes.get(currentCharIndex);
    }

    public void restartListener(View view) {

        if (morseCodeGenerator.charactersPoolIsEmpty) {
            answerTextView.setText("Выберите символы для тренировки");
        }else if (numberOfGroups == 0) {
            answerTextView.setText("Выберите количество групп");
        } else {
            answerTextView.setText("");
            startListening();
        }
    }

    public void showSettingsDialog(View view) {
        openTextChooseCharactersDialog(view);
    }
}
