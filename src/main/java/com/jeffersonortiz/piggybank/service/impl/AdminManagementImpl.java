package com.jeffersonortiz.piggybank.service.impl;

import com.jeffersonortiz.piggybank.domain.dto.UserDTO;
import com.jeffersonortiz.piggybank.domain.entity.User;
import com.jeffersonortiz.piggybank.repository.IUserRepository;
import com.jeffersonortiz.piggybank.service.AdminManagement;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminManagementImpl implements AdminManagement {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public User createUser(UserDTO user) {
    User newUser = User.builder()
            .name(user.getName())
            .lastName(user.getLastName())
            .uuidLogin(user.getUuid())
            .build();

    newUser = userRepository.save(newUser);
    return newUser;
  }
}
