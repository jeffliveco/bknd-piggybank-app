package com.jeffersonortiz.piggybank.service;

import com.jeffersonortiz.piggybank.exception.BankServiceException;

public interface Bank {
    void addCash(Integer cash) throws BankServiceException;
    Double getTotalCash() throws BankServiceException;
    Double getCashByCoin(Integer coin) throws BankServiceException;
}
