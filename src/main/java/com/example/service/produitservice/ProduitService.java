package com.example.service.produitservice;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.enity.Client;
import com.example.enity.Produit;
import com.example.exeption.EntityNotFoundExeption;
import com.example.model.clientmodel.ClientResponseDto;
import com.example.model.produitmodel.ProduitRequestDto;
import com.example.model.produitmodel.ProduitResponseDto;
import com.example.repository.ClientRepository;
import com.example.repository.ProduitRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;

@Service

public class ProduitService implements ServiceProduit   {
    @Autowired
    private ProduitRepository produitRepository;
    private final ModelMapper modelMapper;

     public ProduitService(ProduitRepository produitRepository , ModelMapper modelMapper){
       this.produitRepository = produitRepository;
       this.modelMapper = modelMapper;
   }
    @Override
    public ProduitResponseDto save(ProduitRequestDto produitRequestDto) {
        Produit produit = modelMapper.map(produitRequestDto, Produit.class);
       Produit saved= produitRepository.save(produit);

       return modelMapper.map(saved ,ProduitResponseDto.class );
    }

     @Override
     public ProduitResponseDto findById(Integer id) {
         Produit produit =produitRepository.findById(id).orElseThrow(()->new EntityNotFoundException("produit not found"));
         return modelMapper.map(produit, ProduitResponseDto.class);
     }

     @Override
     public ProduitResponseDto findByNom(String libelle) {
           Produit produit =produitRepository.findByLibelle(libelle);
         return modelMapper.map(produit, ProduitResponseDto.class);
     }

     @Override
     public void delete(Integer id) {
         produitRepository.deleteById(id);
     }

     @Override
     public ProduitResponseDto update(ProduitRequestDto produitRequestDto, Integer id) throws EntityNotFoundException {
        Optional<Produit> cOptional=produitRepository.findById(id);
        if(cOptional.isPresent()){
            Produit produit =modelMapper.map(produitRequestDto, Produit.class);
            produit.setId(id);
            Produit updated = produitRepository.save(produit);
            return modelMapper.map(updated, ProduitResponseDto.class);
        }else{
            throw new EntityNotFoundException("Produit not found ");
        }

    }

     @Override
     public List<Produit> finAllClients() {
         return produitRepository.findAll();
     }

   
    
}
