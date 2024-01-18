package com.example.repository;



import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.enity.Facteur;

/**
 * FactureRepository
 */
@Repository
@Transactional
public interface FactureRepository extends JpaRepository<Facteur,Integer>{

    // Facteur findByLibelle(String ref);
} 