package com.test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sakhtar on 06/08/2015.
 */
public class Test {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new CardOne());
        cards.add(new CardTwo());

        Map<String, Card> cardMap = new HashMap<>();
        cardMap.put("one", new CardOne());
        cardMap.put("two", new CardTwo());

    }
}
