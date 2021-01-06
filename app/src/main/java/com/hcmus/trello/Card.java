package com.hcmus.trello;

import java.io.Serializable;

public class Card implements Serializable {
    private String card_name;
    public Card(String name){
        card_name = name;
    }
    public String getName() {
        return card_name;
    }
}
