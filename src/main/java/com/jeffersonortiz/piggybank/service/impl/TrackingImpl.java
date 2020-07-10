package com.jeffersonortiz.piggybank.service.impl;

import com.jeffersonortiz.piggybank.component.CoinComponent;
import com.jeffersonortiz.piggybank.domain.entity.SavingsAccount;
import com.jeffersonortiz.piggybank.domain.entity.Transaction;
import com.jeffersonortiz.piggybank.domain.entity.User;
import com.jeffersonortiz.piggybank.exception.BankServiceException;
import com.jeffersonortiz.piggybank.exception.CoinNotSupportedException;
import com.jeffersonortiz.piggybank.repository.ISavingsAccountRepository;
import com.jeffersonortiz.piggybank.repository.ITransactionRepository;
import com.jeffersonortiz.piggybank.repository.IUserRepository;
import com.jeffersonortiz.piggybank.service.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingImpl implements Tracking {

    private static String UUID_SESSION = "7c54f655-608b-4e5a-87a1-dd877a141908";

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private CoinComponent coinComponent;

    @Autowired
    private ISavingsAccountRepository savingsAccount;

    @Override
    public Integer getTotalCoins()  {
        User userInSession = this.getUser(UUID_SESSION);
        SavingsAccount existSavings = savingsAccount.findByUser(userInSession);

        if(existSavings == null) {
            throw new BankServiceException("DONT_EXIST_ACCOUNT");
        }

        List<Transaction> transactionHistory = transactionRepository.findCountByAccount(existSavings);

        if(transactionHistory == null) {
            throw new BankServiceException("DONT_HAVE_TRANSACTION");
        }

        return transactionHistory.size();
    }

    @Override
    public Integer getCountByCoin(Integer coin) {
        try {
            String kindCoin = coinComponent.getCoinByValue(coin);

            User userInSession = this.getUser(UUID_SESSION);
            SavingsAccount existSavings = savingsAccount.findByUser(userInSession);

            if(existSavings == null) {
                throw new BankServiceException("DONT_EXIST_ACCOUNT");
            }

            List<Transaction> transactionHistory = transactionRepository.findGroupByCoinAndAccount(kindCoin, existSavings);

            if(transactionHistory == null) {
                throw new BankServiceException("DONT_HAVE_TRANSACTION");
            }

            return transactionHistory.size();
        } catch (CoinNotSupportedException e){
            throw new BankServiceException("COIN_NOT_SUPPORTED");
        }
    }

    private User getUser(String uuid){
        return userRepository.findByUuidLogin(uuid);
    }
}
