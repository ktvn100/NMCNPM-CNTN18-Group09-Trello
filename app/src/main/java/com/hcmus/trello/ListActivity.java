package com.hcmus.trello;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity{
    EditText edtListName;
    List list;
    RecyclerView recyclerView;
    RecyclerView.Adapter cardAdapter;
    RelativeLayout rl_emptyList;
    RecyclerView.LayoutManager layoutManager;
    EditText edt_newCard;
    Button btn_addNewCard;
    Button btn_sort;
    String listName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (List) getIntent().getSerializableExtra("list");
        listName = list.getName().toString();

        edtListName = findViewById(R.id.edt_list_name);
        edt_newCard = findViewById(R.id.edt_new_card);
        btn_addNewCard = findViewById(R.id.btn_add_new_card);
        btn_sort = findViewById(R.id.btn_sort);
        rl_emptyList = findViewById(R.id.empty_list);
        recyclerView = findViewById(R.id.recycler_view_card);

        cardAdapter = new RecycleViewAdapterCard(this, list);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cardAdapter);

        OnListChanged();

        edtListName.setText(listName);

        edtListName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                    listName = s.toString();
                    list.rename(listName);
            }

        });


        edt_newCard.addTextChangedListener(new TextWatcher() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty())
                    btn_addNewCard.setClickable(false);
                else
                    btn_addNewCard.setClickable(true);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty())
                    btn_addNewCard.setClickable(false);
                else
                    btn_addNewCard.setClickable(true);
            }
        });

        btn_addNewCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(btn_addNewCard.isClickable())
                {
                    list.addCard(new Card(edt_newCard.getText().toString()));
                    OnListChanged();
                    edt_newCard.setText("");
                }
            }
        });

        btn_sort.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                list.sort();
                OnListChanged();
            }
        });
    }

    public void OnListChanged() {
        if (cardAdapter.getItemCount() == 0)
        {
            rl_emptyList.setVisibility(View.VISIBLE);
        }
        else
        {
            rl_emptyList.setVisibility(View.GONE);
        }
        cardAdapter.notifyDataSetChanged();
    }
}
