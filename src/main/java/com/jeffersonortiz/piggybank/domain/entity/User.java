package com.jeffersonortiz.piggybank.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String lastName;
  private String uuidLogin;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user")
  @Singular
  private Set<LoginProvider> providers;
  @OneToOne
  private SavingsAccount account;
}
