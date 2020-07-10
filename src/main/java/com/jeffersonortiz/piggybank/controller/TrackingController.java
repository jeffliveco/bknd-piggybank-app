package com.jeffersonortiz.piggybank.controller;

import com.jeffersonortiz.piggybank.exception.BankServiceException;
import com.jeffersonortiz.piggybank.exception.RestServiceException;
import com.jeffersonortiz.piggybank.service.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @Autowired
    private Tracking trackingService;

    @GetMapping("/coin")
    public ResponseEntity<Double> getTotalCoins() {
        try {
            return new ResponseEntity(trackingService.getTotalCoins(), HttpStatus.OK);
        } catch (BankServiceException ex){
            throw new RestServiceException(ex.getMessage());
        }
    }

    @GetMapping("/coin/{coin}")
    public ResponseEntity<Double> getTotalCoins(@PathVariable Integer coin) {
        try {
            return new ResponseEntity(trackingService.getCountByCoin(coin), HttpStatus.OK);
        } catch (BankServiceException ex){
            throw new RestServiceException(ex.getMessage());
        }
    }
}
