package com.jeffersonortiz.piggybank.repository;

import com.jeffersonortiz.piggybank.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
