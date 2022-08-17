package com.apigestionregions.Apigestionregions.modele;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*Là nous avons la classe Population*/
@Entity/*Permet de montrer que notre classe qui va suivre est un entité ainsi elle sera créer dans la base de donnée*/
@Table(name = "Population")/*Permet de donner un nom a notre table*/
@Getter/*Permet de créer les getters de ma classe Population grace la dependance lombok*/
@Setter/*Permet de créer les setters de ma classe  Population grace la dependance lombok*/
@AllArgsConstructor/*Permet de créer un constructeur avec argument*/
@NoArgsConstructor/*Permet de créer un constructeur sans argument*/
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annee;
    private Long nbHabitant;

    @ManyToOne
   Regions regions;

}
