package com.hcmus.trello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    List list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new List("mylist");
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        intent.putExtra("list", list);
        startActivity(intent);

    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        //startActivity(new Intent(getApplicationContext(),Login.class));
        startActivity(new Intent(getApplicationContext(), CardActivity.class));
        finish();
    }
}