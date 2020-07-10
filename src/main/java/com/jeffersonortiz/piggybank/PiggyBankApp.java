package com.jeffersonortiz.piggybank;

import com.jeffersonortiz.piggybank.domain.dto.LoginProviderDTO;
import com.jeffersonortiz.piggybank.domain.dto.UserDTO;
import com.jeffersonortiz.piggybank.repository.IUserRepository;
import com.jeffersonortiz.piggybank.service.AdminManagement;
import com.jeffersonortiz.piggybank.service.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PiggyBankApp {

  @Autowired
  private AdminManagement adminService;

  @Autowired
  private Bank bankService;

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
        .uuid("7c54f655-608b-4e5a-87a1-dd877a141908")
        .provider(provider)
        .build();

      adminService.createUser(user);


    });
  }

}
