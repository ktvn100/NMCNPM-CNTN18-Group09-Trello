package com.hcmus.trello;

import java.util.ArrayList;

public class Board {
    String mName;
    ArrayList<String> mListMyList;

    public Board(String mName, ArrayList<String> mListMyList) {
        this.mName = mName;
        this.mListMyList = mListMyList;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public ArrayList<String> getListMyList() {
        return mListMyList;
    }

    public void setListMyList(ArrayList<String> mListMyList) {
        this.mListMyList = mListMyList;
    }
}
