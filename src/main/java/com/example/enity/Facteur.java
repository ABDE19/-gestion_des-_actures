package com.example.enity;

import java.io.Serializable;
import java.sql.Date;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Facteur implements Serializable{
    @Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String ref;
	
	@Column(nullable = false,name = "date_creation_facture")
	private Date date;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)

	private Client client;

	@OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Produit> produitsList;



}
