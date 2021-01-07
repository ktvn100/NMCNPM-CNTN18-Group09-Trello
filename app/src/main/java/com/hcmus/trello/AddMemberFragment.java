package com.hcmus.trello;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddMemberFragment extends AppCompatDialogFragment {
    CheckBox qVu;
    CheckBox hHuy;
    CheckBox tSon;
    CheckBox hThe;
    CheckBox qTien;
    Integer checkCount=0;
    AddMemberFragmentListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_setmember,null);
        qVu = view.findViewById(R.id.quangVu);
        hHuy = view.findViewById(R.id.hongHuy);
        tSon = view.findViewById(R.id.thaiSon);
        hThe = view.findViewById(R.id.hoangThe);
        qTien = view.findViewById(R.id.quangTien);
        builder.setView(view).setTitle("Add Participant")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    if (qVu.isChecked()) checkCount++;
                    if (hHuy.isChecked()) checkCount++;
                    if (tSon.isChecked()) checkCount++;
                    if (hThe.isChecked()) checkCount++;
                    if (qTien.isChecked()) checkCount++;
                    String memberCount= checkCount.toString()+" member(s) added!";
                    listener.applyTexts(memberCount);
                    }
                });


        return  builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener=(AddMemberFragmentListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement AddMemberFragmentListener!");
        }

    }

    public interface AddMemberFragmentListener{
        void applyTexts(String memberCount);
    }
}
