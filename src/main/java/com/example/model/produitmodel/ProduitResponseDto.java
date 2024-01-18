package com.example.model.produitmodel;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProduitResponseDto {
	private Integer id;
	
	private String libelle;
	
	private String 	ref;
	
	
	private BigDecimal prix;
	
	
	private Double quantite_stock;
}
