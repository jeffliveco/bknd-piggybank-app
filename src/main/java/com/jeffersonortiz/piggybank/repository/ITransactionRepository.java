package com.jeffersonortiz.piggybank.repository;

import com.jeffersonortiz.piggybank.domain.entity.SavingsAccount;
import com.jeffersonortiz.piggybank.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.coin = ?1 and t.account = ?2")
    List<Transaction> findGroupByCoinAndAccount(String kind, SavingsAccount account);

    @Query("SELECT t FROM Transaction t WHERE t.account = ?1")
    List<Transaction> findCountByAccount(SavingsAccount account);
}
