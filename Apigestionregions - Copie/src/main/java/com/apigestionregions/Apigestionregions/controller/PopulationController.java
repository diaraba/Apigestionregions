package com.apigestionregions.Apigestionregions.controller;

import com.apigestionregions.Apigestionregions.modele.Pays;
import com.apigestionregions.Apigestionregions.modele.Population;
import com.apigestionregions.Apigestionregions.modele.Regions;
import com.apigestionregions.Apigestionregions.service.PopulationService;
import com.apigestionregions.Apigestionregions.service.RegionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
@Api(value = "hello", description = "Les requetes possible sur ma table population")
@RestController
@RequestMapping("/population")
@AllArgsConstructor
public class PopulationController {
    private final PopulationService populationService;
    private final RegionsService  regionsService;




    /*LA CREATION D'UNE ENTREE POUR LA POPULATION C'EST A DIRE SON CONTENU*/
    @PostMapping("/create")
    @ApiOperation(value = "Permet de creer une population")
    public Population creer(@RequestBody Population population) {

        return populationService.creer(population);
    }





   /*LA RECUPERATION DE LA POPULATION SOUS FORME DE LISTE*/
   @ApiOperation(value = "Permet d'optenir une liste des population creer")
   @GetMapping("/read")
    public Iterable<Object[]> lire() {
        return populationService.lire();
    }





    /*Permet d'obtenir une liste du nombre d'habitant et l'année ce la population en fonction de la region entrer*/
    @ApiOperation(value = "Permet d'obtenir une liste du nombre d'habitant et l'année ce la population en fonction de la region entrer")
    @GetMapping("/read1/{regions}")
    public Iterable<Object[]> lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(@PathVariable String regions) {
        return populationService.lireFIND_EN_FONCTION_REGIONENTRER_ALL_NONMBRE_HABITANT_AND_ANNEE(regions);
    }






    /*lA MISE A JOUR DE LA POPULATION*/
    @PutMapping("/update/{idPopulation}")
    @ApiOperation(value = "Permet de modifier la population")
    public Population update(@PathVariable Long idPopulation, @RequestBody Population population) {
        return populationService.modifier(idPopulation,population);
    }





    /*Permet de modifier la population*/
    @ApiOperation(value = "Permet de modifier la population")
    @DeleteMapping("/delete/{id}")
    public String supprimer(@PathVariable Long id) {
        return populationService.supprimer(id);
    }







}
