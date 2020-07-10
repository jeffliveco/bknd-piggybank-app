package com.jeffersonortiz.piggybank.service;

import com.jeffersonortiz.piggybank.domain.dto.UserDTO;
import com.jeffersonortiz.piggybank.domain.entity.User;

public interface AdminManagement {
  User createUser(UserDTO user);
}
