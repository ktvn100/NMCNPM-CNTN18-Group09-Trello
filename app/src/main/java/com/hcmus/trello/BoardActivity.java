package com.hcmus.trello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity implements MyListAdapter.OnItemListener {

    private static final String TAG = "BoardActivity";

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout mDrawerLayout;
    RecyclerView mRecyclerView;
    ArrayList<String> mListNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        setTitle("Board1");

        initUI();


    }

    private void initUI() {
        initToolbar();
        initRecyclerView();
        mDrawerLayout = findViewById(R.id.drawerLayout_board);
        FloatingActionButton fab = findViewById(R.id.btn_addList);
        fab.setOnClickListener(view -> Snackbar.make(view, "Add new list activity", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView_board);
        mListNames = DummyData.getListNames();
        Log.d(TAG, "initRecyclerView: " + mListNames.size());
        MyListAdapter adapter = new MyListAdapter(mListNames, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_board);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.movevert:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                return true;
            case R.id.notification:
                Toast.makeText(this, "Show notification ", Toast.LENGTH_SHORT).show();
                return true;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStarClick(int position) {
        Toast.makeText(this, "Clicked star on line " + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMoreHorizClick(int position) {
        Toast.makeText(this, "Clicked More horiz on line " + position, Toast.LENGTH_LONG).show();
    }

    //Intent vao list dat o day
    @Override
    public void onListNameClick(int position) {
        Toast.makeText(this, "Open list: " + mListNames.get(position), Toast.LENGTH_LONG).show();
    }


}