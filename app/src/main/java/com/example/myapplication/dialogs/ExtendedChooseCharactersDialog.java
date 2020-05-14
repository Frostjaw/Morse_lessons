package com.example.myapplication.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.activities.SettingsActivity;

public class ExtendedChooseCharactersDialog extends ChooseCharactersDialog {

    OnGroupNumberSelectedListener groupNumberCallback;

    public void setOnGroupNumberSelectedListener(OnGroupNumberSelectedListener callback) {
        this.groupNumberCallback = callback;
    }

    public interface OnGroupNumberSelectedListener {
        public void OnGroupNumberSelected(int numberOfGroups);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.extended_choose_characters_dialog, null);

        EditText charactersEditText = view.findViewById(R.id.characters_editText);
        EditText groupNumberEditText = view.findViewById(R.id.group_number_editText);

        // settings button
        Button openGlobalSettingsButton = view.findViewById(R.id.global_settings_button);
        openGlobalSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

        // letters
        CheckBox lettersCheckBox = view.findViewById(R.id.letters_checkBox);
        lettersCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String letters = "абвгдежзийклмнопрстуфхцчшщыьэюя";
                String characters = charactersEditText.getText().toString();

                if(isChecked) {
                    if (!characters.contains(letters))
                    {
                        charactersEditText.append(letters);
                    }
                }
                else {
                    characters = characters.replace(letters, "");
                    charactersEditText.setText(characters);
                }
            }
        });

        // numbers
        CheckBox numbersCheckBox = view.findViewById(R.id.numbers_checkBox);
        numbersCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String numbers = "1234567890";
                String characters = charactersEditText.getText().toString();

                if(isChecked) {
                    if (!characters.contains(numbers)) {
                        charactersEditText.append(numbers);
                    }
                }
                else {
                    characters = characters.replace(numbers, "");
                    charactersEditText.setText(characters);
                }
            }
        });

        // punctuation marks
        CheckBox punctuationCheckBox = view.findViewById(R.id.punctuation_checkBox);
        punctuationCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String punctuationMarks = ".,:;()'\\-/?!разделперебой@конецсвязи"; // HERE
                String characters = charactersEditText.getText().toString();

                if(isChecked) {
                    if (!characters.contains(punctuationMarks)) {
                        charactersEditText.append(punctuationMarks);
                    }
                }
                else {
                    characters = characters.replace(punctuationMarks, "");
                    charactersEditText.setText(characters);
                }
            }
        });

        // ok button
        Button acceptSymbolsButton = view.findViewById(R.id.accept_characters_button);
        acceptSymbolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters = charactersEditText.getText().toString().toLowerCase();

                // selectedCharacters[0] - characters without punctuations marks
                // selectedCharacters[1] - punctuations marks
                String[] selectedCharacters = findPunctuationMarks(characters);
                charactersCallback.onCharactersSelected(selectedCharacters);

                String numberOfGroupsString = groupNumberEditText.getText().toString();
                if (!numberOfGroupsString.equals("")) {
                    int numberOfGroups = Integer.parseInt(numberOfGroupsString);
                    groupNumberCallback.OnGroupNumberSelected(numberOfGroups);
                }

                dismiss();
            }
        });

        return view;
    }

}
