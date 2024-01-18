package com.example.model.facturemodel;

import java.sql.Date;
import java.util.List;

import com.example.enity.Client;

import com.example.enity.Produit;
import lombok.*;


/**
 * FactureRespence
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class FactureRespence {

    private Integer id;
	
	private String ref;
	
	private Date date;

	private Client client;
	private List<Produit> produits;
}