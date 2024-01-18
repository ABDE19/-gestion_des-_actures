package com.example.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.facturemodel.FactureRequest;
import com.example.model.facturemodel.FactureRespence;

import com.example.service.factureservice.FactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Facture")


public class FactureController {
    @Autowired
    private FactureService factureService;




    @PostMapping("/path")
    public ResponseEntity< FactureRespence> save(@RequestBody FactureRequest factureRequest) {
        FactureRespence factureRespence=factureService.save(factureRequest);
        return new ResponseEntity<>(factureRespence,HttpStatus.CREATED);
    }

    
    

}
