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
import com.jeffersonortiz.piggybank.service.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankImpl implements Bank {

    private static String UUID_SESSION = "7c54f655-608b-4e5a-87a1-dd877a141908";

    @Autowired
    private CoinComponent coinComponent;

    @Autowired
    private ISavingsAccountRepository savingsAccount;

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void addCash(Integer cash) throws BankServiceException {
        try {
            String kindCoin = coinComponent.getCoinByValue(cash);

            User userInSession = this.getUser(UUID_SESSION);
            SavingsAccount account = createOrUpdateSavingsAccount(userInSession, cash);

            Transaction transaction = Transaction.builder()
                    .account(account)
                    .value(Double.valueOf(cash))
                    .coin(kindCoin)
                    .build();

            transactionRepository.save(transaction);
        } catch (CoinNotSupportedException e){
            throw new BankServiceException("COIN_NOT_SUPPORTED");
        }
    }

    @Override
    public Double getTotalCash() throws BankServiceException {
        User userInSession = this.getUser(UUID_SESSION);
        SavingsAccount existSavings = savingsAccount.findByUser(userInSession);

        if(existSavings == null) {
            throw new BankServiceException("DONT_EXIST_ACCOUNT");
        }

        return existSavings.getValue();
    }

    @Override
    public Double getCashByCoin(Integer coin) throws BankServiceException {
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

            return transactionHistory.stream()
                    .mapToDouble(x -> x.getValue())
                    .sum();
        } catch (CoinNotSupportedException e){
            throw new BankServiceException("COIN_NOT_SUPPORTED");
        }
    }

    private User getUser(String uuid){
        return userRepository.findByUuidLogin(uuid);
    }

    private SavingsAccount createOrUpdateSavingsAccount(User session, Integer value) {
        SavingsAccount existSavings = savingsAccount.findByUser(session);
        if (existSavings != null) {
            existSavings.setValue(existSavings.getValue() + value);
            existSavings = savingsAccount.save(existSavings);
        } else {
            SavingsAccount newAccount = SavingsAccount.builder()
                    .user(session)
                    .value(Double.valueOf(value))
                    .build();
            existSavings = savingsAccount.save(newAccount);

            session.setAccount(existSavings);
            userRepository.save(session);
        }
        return existSavings;
    }
}
