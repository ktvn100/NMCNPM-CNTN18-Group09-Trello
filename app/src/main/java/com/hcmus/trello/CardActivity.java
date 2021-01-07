package com.hcmus.trello;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;

public class CardActivity extends AppCompatActivity implements AddMemberFragment.AddMemberFragmentListener,ChangeBackgroundFragment.ChangeBackgroundFragmentListener {
    MaterialButton deadlineBtn;
    MaterialButton addMemberBtn;
    MaterialButton changeBackgroundBtn;
    MaterialButton attachmentBtn;
    MaterialButton setCardBtn;
    MaterialButton detailsBtn;
    LinearLayout cardLayout;
    TextInputEditText cardNameId;
    String cardName;
    Card card;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //card = (Card) getIntent().getSerializableExtra("card");
        //cardName = card.getName().toString();
        setContentView(R.layout.activity_card);
        //cardNameId = findViewById(R.id.card_name);
        //cardNameId.setText(cardName);
        deadlineBtn = findViewById(R.id.setDeadline);
        addMemberBtn = findViewById(R.id.addMember);
        changeBackgroundBtn = findViewById(R.id.changeBackground);
        attachmentBtn = findViewById(R.id.addAttachment);
        setCardBtn = findViewById(R.id.setCard);
        detailsBtn = findViewById(R.id.detail);
        cardLayout=findViewById(R.id.cardLayout);

        changeBackgroundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangeBackground();
            }
        });
        addMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openAddMember();
            }
        });
        deadlineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(CardActivity.this,
                        mDateSetListener,year,month,day);
                dialog.show();
            }
        });
        mDateSetListener=new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR,year);
                c.set(Calendar.MONTH,month);
                c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                String setDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
                deadlineBtn.setText(setDateString);
            }
        };
    }

    private void openChangeBackground() {
        ChangeBackgroundFragment changeBackgroundFragment = new ChangeBackgroundFragment();
        changeBackgroundFragment.show(getSupportFragmentManager(),"Change Background");
    }

    private void openAddMember() {
        AddMemberFragment memberFragment = new AddMemberFragment();
        memberFragment.show(getSupportFragmentManager(),"Add Participant");

    }

    @Override
    public void applyTexts(String memberCount) {
        addMemberBtn.setText(memberCount);
    }

    @Override
    public void applyColor(String color) {
        if (color=="Gray") cardLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.gray));
        else if (color=="Red") cardLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
        else if (color=="Purple") cardLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.purple_200));
        else if (color=="Aqua") cardLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.aqua));
        else if (color=="Teal") cardLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_700));
    }
}
