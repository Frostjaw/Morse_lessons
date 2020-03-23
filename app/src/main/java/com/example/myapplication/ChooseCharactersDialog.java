package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class ChooseCharactersDialog extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.choose_characters_dialog, null);

        EditText charactersEditText = view.findViewById(R.id.characters_editText);

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
        acceptSymbolsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String characters = charactersEditText.getText().toString().toLowerCase();

                // strings[0] - characters without punctuations marks
                // strings[1] - punctuations marks
                String[] strings = findPunctuationMarks(characters);

                char[] charArray = strings[0].toCharArray();
                //char[] charArray = characters.toCharArray();

                // !!! explicit call activity field method
                ((ReceptionTrainerActivity)getActivity()).morseCodeGenerator.setCharacterPoolForGeneration(charArray);

                char[] punctuationMarksArray = strings[1].toCharArray();
                ((ReceptionTrainerActivity)getActivity()).morseCodeGenerator.addPunctuationMarksToPool(punctuationMarksArray);

                dismiss();
            }
        });

        return view;
    }

    public void onClick(View v) {
        Log.d(LOG_TAG, "ChooseCharactersDialog: " + ((Button) v).getText());
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "ChooseCharactersDialog: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "ChooseCharactersDialog: onCancel");
    }

    private String[] findPunctuationMarks(String characters){
        //String stringWithoutPunctuationMarks = "";
        String punctuationMarks = "";

        // .
        if (characters.contains(".")){
            characters.replace(".", "");
            punctuationMarks += ".";
        }

        // ,
        if (characters.contains(",")){
            characters.replace(",", "");
            punctuationMarks += ",";
        }

        // :
        if (characters.contains(":")){
            characters.replace(":", "");
            punctuationMarks += ":";
        }

        // ;
        if (characters.contains(";")){
            characters.replace(";", "");
            punctuationMarks += ";";
        }

        // ( )
        if (characters.contains("( )")){
            characters.replace("( )", "");
            punctuationMarks += "( )";
        }

        // '
        if (characters.contains("'")){
            characters.replace("'", "");
            punctuationMarks += "'";
        }

        // \
        if (characters.contains("\\")){
            characters.replace("\\", "");
            punctuationMarks += "\\";
        }

        // -
        if (characters.contains("-")){
            characters.replace("-", "");
            punctuationMarks += "-";
        }

        // /
        if (characters.contains("/")){
            characters.replace("/", "");
            punctuationMarks += "/";
        }

        // ?
        if (characters.contains("?")){
            characters.replace("?", "");
            punctuationMarks += "?";
        }

        // !
        if (characters.contains("!")){
            characters.replace("!", "");
            punctuationMarks += "!";
        }

        // раздел
        if (characters.contains("раздел")){
            characters.replace("раздел", "");
            punctuationMarks += "d";
        }

        // перебой
        if (characters.contains("перебой")){
            characters.replace("перебой", "");
            punctuationMarks += "i";
        }

        // @
        if (characters.contains("@")){
            characters.replace("@", "");
            punctuationMarks += "@";
        }

        // конец связи
        if (characters.contains("конецсвязи")){
            characters.replace("конецсвязи", "");
            punctuationMarks += "e";
        }

        String[] strings = new String[2];
        strings[0] = characters;
        strings[1] = punctuationMarks;

        return strings;
    }

}
