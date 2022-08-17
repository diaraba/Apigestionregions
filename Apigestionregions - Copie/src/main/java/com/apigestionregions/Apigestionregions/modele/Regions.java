package com.apigestionregions.Apigestionregions.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/*Là nous avons la classe Regions*/
@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Regions")/*Permet de donner un nom a notre table*/
@Getter/*Permet de créer les getters de ma classe Regions grace la dependance lombok*/
@Setter/*Permet de créer les setters de ma classe Regions grace la dependance lombok*/
@AllArgsConstructor/*Permet de créer un constructeur avec argument*/
@NoArgsConstructor/*Permet de créer un constructeur sans argument*/
public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeRegions;
    private String nomregions;
    private String langue;
    private String superficie_regions;
    private String domaine_activite;

    @ManyToOne
    private Pays pays;

   /* @ManyToOne
    @JoinColumn(name = "population_id_population")
    private Population population;*/
}
