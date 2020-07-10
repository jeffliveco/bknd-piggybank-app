package com.jeffersonortiz.piggybank.service.impl;

import com.jeffersonortiz.piggybank.domain.dto.UserDTO;
import com.jeffersonortiz.piggybank.domain.entity.LoginProvider;
import com.jeffersonortiz.piggybank.domain.entity.User;
import com.jeffersonortiz.piggybank.repository.IUserRepository;
import com.jeffersonortiz.piggybank.service.AdminManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminManagementImpl implements AdminManagement {

  @Autowired
  private IUserRepository userRepository;

  @Override
  public User createUser(UserDTO user) {
    final User.UserBuilder newUser = User.builder()
            .name(user.getName())
            .lastName(user.getLastName())
            .uuidLogin(user.getUuid());

    user.getProviders().forEach((provider) -> {
      LoginProvider newProvider = LoginProvider.builder()
              .kind(provider.getKind())
              .value(provider.getValue())
              .build();
      newUser.provider(newProvider);
    });

    return userRepository.save(newUser.build());
  }
}
