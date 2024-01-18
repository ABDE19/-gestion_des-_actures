package com.example.service.factureservice;

import com.example.enity.Client;
import com.example.enity.Produit;
import com.example.repository.ClientRepository;
import com.example.repository.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enity.Facteur;
import com.example.model.facturemodel.FactureRequest;
import com.example.model.facturemodel.FactureRespence;
import com.example.repository.FactureRepository;

import java.util.List;

/**
 * FactureService
 */
@Service
public class FactureService {
    @Autowired
private FactureRepository factureRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProduitRepository produitRepository;
private  final ModelMapper modelMapper;
FactureService(FactureRepository factureRepository , ModelMapper modelMapper,ClientRepository clientRepository,ProduitRepository produitRepository){
    this.factureRepository = factureRepository;
    this.modelMapper = modelMapper;
//    this.clientRepository=clientRepository;
//    this.produitRepository=produitRepository;
}


    public FactureRespence save(FactureRequest factureRequest){
        Facteur facteur = modelMapper.map(factureRequest, Facteur.class);

        List<Produit> produits = factureRequest.getProduits();
        if (produits != null) {
            for (Produit produit : produits) {
                produit.setFacture(facteur);
                 produitRepository.save(produit);
            }
        }

        Client client = clientRepository.save(facteur.getClient());

        facteur.setProduitsList(produits);
        facteur.setClient(client);

        Facteur facteur2 = factureRepository.save(facteur);
        return modelMapper.map(facteur2, FactureRespence.class);

    }
}