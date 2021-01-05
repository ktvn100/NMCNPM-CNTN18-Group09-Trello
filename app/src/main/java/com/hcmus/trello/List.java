package com.hcmus.trello;

import java.util.ArrayList;

public class List {
    private int ID;
    private boolean isArchive;
    private String list_name;
    private ArrayList<Card> list_cards;

    public List(int _ID, String _lname)
    {
        ID = _ID;
        list_name = _lname;
        isArchive = false;
        list_cards.clear();
    }

    public List(String _lname)
    {
        ID = 0;
        list_name = _lname;
        isArchive = false;
        list_cards.clear();
    }

    public List(int _ID, String _lname, boolean _isAr, ArrayList<Card> _lcard)
    {
        ID=_ID;
        list_name=_lname;
        list_cards=_lcard;
        isArchive=_isAr;
    }

    public String getList_name(){
        return list_name;
    }

    public void addCard(Card c)
    {
        list_cards.add(c);
    }

    public void deleteCard(Card c)
    {
        list_cards.remove(c);
    }

    public void rename(String new_lname)
    {
        list_name = new_lname;
    }
}
