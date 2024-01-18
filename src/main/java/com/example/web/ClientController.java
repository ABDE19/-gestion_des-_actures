package com.example.web;
import com.example.enity.Client;
import com.example.model.clientmodel.ClientRequestDto;
import com.example.model.clientmodel.ClientResponseDto;
import com.example.model.produitmodel.ProduitRequestDto;
import com.example.model.produitmodel.ProduitResponseDto;
import com.example.service.clientservice.ClientServiceImpl;
import com.example.service.produitservice.ProduitService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/user")

public class ClientController {
    @Autowired 
    private ClientServiceImpl clientService;
        private ProduitService produitService;

    // private ClientService clientService;
    // public ClientController(ClientService clientService){
    //     this.clientService=clientService;
    // }
@GetMapping("/findById/{id}")
public ResponseEntity < ClientResponseDto > findById(@PathVariable Integer id) {
    ClientResponseDto clientResponseDto=clientService.findById(id);
    return  ResponseEntity.ok(clientResponseDto);
}

    @GetMapping("/getClient")
    public ResponseEntity<List<Client>> getClient(){
        return new ResponseEntity<>(clientService.finAllClients(), HttpStatus.OK);
    }
@PostMapping("/save")
public ResponseEntity<ClientResponseDto>  save(@Valid @RequestBody ClientRequestDto clientRequestDto) {
    ClientResponseDto clientResponseDto=clientService.save(clientRequestDto);
    return new ResponseEntity<>(clientResponseDto , HttpStatus.CREATED);
}
//    public ClientResponseDto save(@RequestBody()  ClientRequestDto clientRequestDto){
//     return clientService.save(clientRequestDto);
//    }
//    @GetMapping
//    public  String hello(){
//        return "hello ";
//    }
 @PostMapping("/savep")
    public ResponseEntity<ProduitResponseDto> seve(@Valid @RequestBody ProduitRequestDto produitRequestDto) {
        ProduitResponseDto produitResponseDto = produitService.save(produitRequestDto);
        return new ResponseEntity<>(produitResponseDto,HttpStatus.CREATED);
    }
@PutMapping("uplode/{id}")

public ResponseEntity< ClientResponseDto> uplode(@Valid @RequestBody ClientRequestDto clientRequestDto,@PathVariable Integer id) {
    
    
        ClientResponseDto clientResponseDto=clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
  
    

    
}


    @GetMapping
    public String hello(){
        return "hello"
;     }
    

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable() Integer id){
     clientService.delete(id);
     return ResponseEntity.noContent().build();
}
}

