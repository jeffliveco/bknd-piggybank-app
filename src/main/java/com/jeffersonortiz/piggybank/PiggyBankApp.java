package com.jeffersonortiz.piggybank;

import com.jeffersonortiz.piggybank.domain.dto.LoginProviderDTO;
import com.jeffersonortiz.piggybank.domain.dto.UserDTO;
import com.jeffersonortiz.piggybank.repository.IUserRepository;
import com.jeffersonortiz.piggybank.service.AdminManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PiggyBankApp {

  @Autowired
  private AdminManagement userRepository;

  @Bean
  public CommandLineRunner demo(){
    return (args -> {
      LoginProviderDTO provider = LoginProviderDTO.builder()
          .kind("EMAIL")
          .value("jeffliveco16@gmail.com")
          .build();

      UserDTO user = UserDTO.builder()
        .name("Jefferson")
        .lastName("Ortiz")
        .uuid("XXfffasdaqw44523244")
        .provider(provider)
        .build();

      userRepository.createUser(user);
    });
  }

}
