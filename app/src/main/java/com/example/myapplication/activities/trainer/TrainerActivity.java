package com.example.myapplication.activities.trainer;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.example.myapplication.activities.MyActivity;
import com.example.myapplication.dialogs.ChooseCharactersDialog;
import com.example.myapplication.dialogs.HelpDialog;

public abstract class TrainerActivity extends MyActivity {

    private DialogFragment chooseCharactersDialog;
    private DialogFragment helpDialog;

    // Logs
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launchActivityWithoutNavigation();
        chooseCharactersDialog = new ChooseCharactersDialog();
        helpDialog = new HelpDialog();
    }

    public void openSettingsDialog(View view) {
        chooseCharactersDialog.show(getSupportFragmentManager(), "choose_characters_dialog");
    }

    public void openHelpDialog(View view) {
        helpDialog.show(getSupportFragmentManager(), "help_dialog");
    }
}
