package com.hcmus.trello;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

public class ChangeBackgroundFragment extends AppCompatDialogFragment {
    RadioButton backgroundTeal;
    RadioButton backgroundPurple;
    RadioButton backgroundRed;
    RadioButton backgroundAqua;
    RadioButton backgroundGray;
    String color;
    ChangeBackgroundFragment.ChangeBackgroundFragmentListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_changebackground,null);
        backgroundAqua = view.findViewById(R.id.backgroundAqua);
        backgroundGray = view.findViewById(R.id.backgroundGray);
        backgroundPurple = view.findViewById(R.id.backgroundPurple);
        backgroundRed = view.findViewById(R.id.backgroundRed);
        backgroundTeal = view.findViewById(R.id.backgroundTeal);
        builder.setView(view).setTitle("Change background")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (backgroundAqua.isChecked()) color ="Aqua";
                        else if (backgroundGray.isChecked()) color ="Gray";
                        else if (backgroundPurple.isChecked()) color ="Purple";
                        else if (backgroundRed.isChecked()) color ="Red";
                        else if (backgroundTeal.isChecked()) color ="Teal";
                       listener.applyColor(color);
                    }
                });


        return  builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener=(ChangeBackgroundFragment.ChangeBackgroundFragmentListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ChangeBackgroundFragmentListener!");
        }

    }

    public interface ChangeBackgroundFragmentListener{
        void applyColor(String color);
    }
}
