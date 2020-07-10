package com.jeffersonortiz.piggybank.controller;

import com.jeffersonortiz.piggybank.domain.dto.AddCoinRequestDTO;
import com.jeffersonortiz.piggybank.exception.BankServiceException;
import com.jeffersonortiz.piggybank.exception.RestServiceException;
import com.jeffersonortiz.piggybank.service.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private Bank bankService;

    @PostMapping("/add-cash")
    public ResponseEntity<String> addCash(@RequestBody AddCoinRequestDTO coinRequest) {
        try {
            bankService.addCash(coinRequest.getValue());
            return new ResponseEntity("OK", HttpStatus.OK);
        } catch (BankServiceException ex){
            throw new RestServiceException(ex.getMessage());
        }
    }

    @GetMapping("/account")
    public ResponseEntity<Double> getTotalAccount() {
        try {
            return new ResponseEntity(bankService.getTotalCash(), HttpStatus.OK);
        } catch (BankServiceException ex){
            throw new RestServiceException(ex.getMessage());
        }
    }

    @GetMapping("/account/{coin}")
    public ResponseEntity<Double> getTotalAccount(@PathVariable Integer coin) {
        try {
            return new ResponseEntity(bankService.getCashByCoin(coin), HttpStatus.OK);
        } catch (BankServiceException ex){
            throw new RestServiceException(ex.getMessage());
        }
    }
}
