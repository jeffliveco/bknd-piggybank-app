package com.jeffersonortiz.piggybank.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class UserDTO {
  private String name;
  private String lastName;
  private String uuid;
  @Singular
  private List<LoginProviderDTO> providers;
}
