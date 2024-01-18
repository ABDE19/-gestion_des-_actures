package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.enity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    
    Client  findByNom(String ref);
}
