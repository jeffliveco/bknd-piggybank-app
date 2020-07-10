package com.jeffersonortiz.piggybank.component;

import com.jeffersonortiz.piggybank.exception.CoinNotSupportedException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoinComponent {
    private static String COIN50 = "50";
    private static String COIN100 = "100";
    private static String COIN200 = "200";
    private static String COIN500 ="500";
    private static String COIN1000 = "1000";

    private List<Integer> coins = new ArrayList<>(5);

    public CoinComponent(){
        coins.add(50);
        coins.add(100);
        coins.add(200);
        coins.add(500);
        coins.add(1000);
    }

    public String getCoinByValue(Integer value) throws CoinNotSupportedException {
        if (!coins.contains(value)){
            throw new CoinNotSupportedException();
        }

        if (value.toString().equals(COIN50)) {
            return COIN50;
        } else if (value.toString().equals(COIN100)) {
            return COIN100;
        } else if (value.toString().equals(COIN200)) {
            return COIN200;
        } else if (value.toString().equals(COIN500)) {
            return COIN500;
        } else {
            return COIN1000;
        }
    }
}
