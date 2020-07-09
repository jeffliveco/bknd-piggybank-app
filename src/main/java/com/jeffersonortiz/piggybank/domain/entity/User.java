package com.jeffersonortiz.piggybank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String lastName;
  private String uuidLogin;
  @OneToMany
  @JoinColumn(name = "user", referencedColumnName = "user")
  private Set<LoginProvider> providers;
}
