package com.example.model.facturemodel;

import java.sql.Date;
import java.util.List;

import com.example.enity.Client;


import com.example.enity.Produit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * FactureRequest
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class FactureRequest {

	
	private String ref;
	
	private Date date;
	private Client client;
	private List<Produit> produits;

}