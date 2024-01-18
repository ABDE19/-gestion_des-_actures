package com.example.web;

import org.springframework.web.bind.annotation.*;

import com.example.enity.Produit;
import com.example.model.produitmodel.ProduitRequestDto;
import com.example.model.produitmodel.ProduitResponseDto;
import com.example.service.produitservice.ProduitService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor

public class ProduitController {
    @Autowired
    private final ProduitService produitService;

    

    @PostMapping("/save")
    public ResponseEntity<ProduitResponseDto> seve(@Valid @RequestBody ProduitRequestDto produitRequestDto) {
        ProduitResponseDto produitResponseDto = produitService.save(produitRequestDto);
        return new ResponseEntity<>(produitResponseDto,HttpStatus.CREATED);
    }
    //  @PostMapping("/save")
    // public ProduitResponseDto seve( @RequestBody ProduitRequestDto produitRequestDto) {
         
    //     return produitService.save(produitRequestDto);
    // }
    @GetMapping
    public String hello(){
        return "hello"
;     }
    
@PutMapping("updat/{id}")
public ResponseEntity<ProduitResponseDto> updat(@PathVariable Integer id, @RequestBody ProduitRequestDto requestDto) {
    ProduitResponseDto produitResponseDto = produitService.update(requestDto, id);
    return ResponseEntity.accepted().body(produitResponseDto);
}
    
@GetMapping("finById/{id}")
public ResponseEntity<ProduitResponseDto> getById(@PathVariable Integer id) {
    ProduitResponseDto produitResponseDto=produitService.findById(id);
    return ResponseEntity.ok(produitResponseDto);
}
@GetMapping("/path")
public ResponseEntity<List<Produit>> getAll() {
    return new ResponseEntity<>(produitService.finAllClients(),HttpStatus.OK);
}

}
