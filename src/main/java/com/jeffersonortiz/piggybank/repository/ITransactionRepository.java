package com.jeffersonortiz.piggybank.repository;

import com.jeffersonortiz.piggybank.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}
