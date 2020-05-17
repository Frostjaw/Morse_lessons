package com.example.myapplication.activities.trainer;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.example.myapplication.activities.SoundActivity;
import com.example.myapplication.dialogs.ChooseCharactersDialog;
import com.example.myapplication.dialogs.TextChooseCharactersDialog;
import com.example.myapplication.dialogs.HelpDialog;

public abstract class TrainerActivity extends SoundActivity {

    private DialogFragment chooseCharactersDialog;
    private DialogFragment textChooseCharactersDialog;
    private DialogFragment helpDialog;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launchActivity();
        chooseCharactersDialog = new ChooseCharactersDialog();
        textChooseCharactersDialog = new TextChooseCharactersDialog();
        helpDialog = new HelpDialog();
    }

    protected void openChooseCharactersDialog(View view) {
        chooseCharactersDialog.show(getSupportFragmentManager(), "choose_characters_dialog");
    }

    protected void openTextChooseCharactersDialog(View view) {
        textChooseCharactersDialog.show(getSupportFragmentManager(), "text_choose_characters_dialog");
    }

    protected void openHelpDialog(View view) {
        helpDialog.show(getSupportFragmentManager(), "help_dialog");
    }
}
