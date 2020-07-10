package com.jeffersonortiz.piggybank.controller;

import com.jeffersonortiz.piggybank.domain.dto.AddCoinRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @PostMapping("/add-cash")
    public ResponseEntity<String> secretDoorBouncer(@RequestBody AddCoinRequestDTO coinRequest) {
        
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}
