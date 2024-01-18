package com.example.service.produitservice;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.enity.Client;
import com.example.enity.Produit;
import com.example.model.clientmodel.ClientRequestDto;
import com.example.model.clientmodel.ClientResponseDto;
import com.example.model.produitmodel.ProduitRequestDto;
import com.example.model.produitmodel.ProduitResponseDto;

public interface ServiceProduit {
        ProduitResponseDto save(ProduitRequestDto produitRequestDto);

    ProduitResponseDto findById(Integer id);

    ProduitResponseDto findByNom(String nom);

    void delete(Integer id);

    ProduitResponseDto update(ProduitRequestDto produitRequestDto,Integer id) throws NotFoundException;

 List<Produit> finAllClients();
}
