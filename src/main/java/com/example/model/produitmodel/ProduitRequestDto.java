package com.example.model.produitmodel;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProduitRequestDto {
        
	
	private String libelle;
	
	private String 	ref;
	
	
	private BigDecimal prix;
	
	
	private Double quantite_stock;
}
