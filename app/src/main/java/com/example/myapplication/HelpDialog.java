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
import android.widget.ImageView;

import java.lang.reflect.Field;

public class HelpDialog extends DialogFragment implements OnClickListener {

    final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.help_dialog, null);
        ImageView characterImageView = view.findViewById(R.id.character_image);

        // !!! explicit call activity field
        int temp = ((ReceptionTrainerActivity)getActivity()).curCharacter;
        if (temp != 0) {
            String curCharacter = Integer.toString(temp);
            String resName = "ch" + curCharacter + "_background";
            int resId = getResId(resName, R.drawable.class);
            characterImageView.setImageResource(resId);
        }

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

    // test
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
