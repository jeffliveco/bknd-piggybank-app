package com.jeffersonortiz.piggybank.repository;

import com.jeffersonortiz.piggybank.domain.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
