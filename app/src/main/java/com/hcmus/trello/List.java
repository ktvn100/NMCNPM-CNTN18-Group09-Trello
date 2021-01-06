package com.hcmus.trello;

import java.io.Serializable;
import java.util.ArrayList;

public class List implements Serializable {
    private int ID;
    private boolean isArchive;
    private String list_name;
    private ArrayList<Card> list_cards;

    public List(int _ID, String _lname)
    {
        list_cards = new ArrayList<>();
        ID = _ID;
        list_name = _lname;
        isArchive = false;
        list_cards.clear();
    }

    public List(String _lname)
    {
        list_cards = new ArrayList<>();
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

    public String getName(){
        return list_name;
    }

    public Card getCard(int position)
    {
        return list_cards.get(position);
    }

    public int getCountCard()
    {
        return list_cards.size();
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
