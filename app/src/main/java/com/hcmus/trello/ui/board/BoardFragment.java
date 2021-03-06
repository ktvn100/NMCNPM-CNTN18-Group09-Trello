package com.hcmus.trello.ui.board;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.hcmus.trello.Board;
import com.hcmus.trello.BoardActivity;
import com.hcmus.trello.CardActivity;
import com.hcmus.trello.ListActivity;
import com.hcmus.trello.MainActivity;
import com.hcmus.trello.R;

import static android.widget.Toast.LENGTH_LONG;

public class BoardFragment extends Fragment {
    private BoardViewModel boardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        boardViewModel = new ViewModelProvider(this).get(BoardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_board, container, false);
        final Button button = root.findViewById(R.id.bth_board);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BoardActivity.class));
                //getActivity().finish();
            }
        });
        boardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}
