package com.jeffersonortiz.piggybank.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "login-provider")
public class LoginProvider {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String kind;
  private String value;
  @OneToMany
  private User user;
}
