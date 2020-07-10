package com.jeffersonortiz.piggybank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class LoginProviderDTO {
    private String kind;
    private String value;
}
