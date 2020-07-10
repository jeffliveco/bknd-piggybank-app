package com.jeffersonortiz.piggybank.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    String message;
    int status;
}
