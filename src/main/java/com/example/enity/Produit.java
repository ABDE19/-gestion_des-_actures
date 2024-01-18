package com.example.enity;
import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(nullable=false)
	private String 	ref;
	
	
	@Column(nullable = false)
	private BigDecimal prix;
	
	
	@Column(nullable = false)
	private Double quantite_stock;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Facteur facture;
}
