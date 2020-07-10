package com.jeffersonortiz.piggybank.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "login_provider")
public class LoginProvider {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String kind;
  private String value;
}
