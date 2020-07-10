package com.jeffersonortiz.piggybank.service;

import com.jeffersonortiz.piggybank.exception.BankServiceException;

public interface Bank {
    void addCash(Integer cash) throws BankServiceException;
    Integer getTotalCash();
    Integer getCashByCoin(Integer coin);
}
