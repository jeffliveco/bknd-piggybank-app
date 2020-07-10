package com.jeffersonortiz.piggybank.repository;

import com.jeffersonortiz.piggybank.domain.entity.SavingsAccount;
import com.jeffersonortiz.piggybank.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

    SavingsAccount findByUser(User user);
}
