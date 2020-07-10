package com.jeffersonortiz.piggybank.service;

import com.jeffersonortiz.piggybank.component.CoinComponent;
import com.jeffersonortiz.piggybank.exception.BankServiceException;
import com.jeffersonortiz.piggybank.exception.CoinNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankImpl implements Bank {

    @Autowired
    private CoinComponent coinComponent;

    @Override
    public void addCash(Integer cash) throws BankServiceException {
        try {
            String kindCoin = coinComponent.getCoinByValue(cash);
        } catch (CoinNotSupportedException e){
            throw new BankServiceException("COIN_NOT_SUPPORTED");
        }
    }

    @Override
    public Integer getTotalCash() {
        return null;
    }

    @Override
    public Integer getCashByCoin(Integer coin) {
        return null;
    }
}
