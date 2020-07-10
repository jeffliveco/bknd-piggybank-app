package com.jeffersonortiz.piggybank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Table(name = "user")
@NoArgsConstructor
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
