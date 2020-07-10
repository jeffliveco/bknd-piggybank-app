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
@Table(name = "savings_account")
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private Double value;
    @Singular
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions;
}
