package com.hcmus.trello.utils;

import com.hcmus.trello.board_screen.Board;

import java.util.ArrayList;

public class DummyData {
    public static ArrayList<String> getListNames()
    {
        ArrayList<String> res = new ArrayList<>();
        res.add("List1");
        res.add("List2");
        res.add("List3");
        res.add("List4");

        return res;
    }
}
