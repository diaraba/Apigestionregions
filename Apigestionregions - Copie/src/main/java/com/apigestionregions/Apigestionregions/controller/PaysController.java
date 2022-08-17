package com.apigestionregions.Apigestionregions.controller;

import com.apigestionregions.Apigestionregions.modele.Pays;
import com.apigestionregions.Apigestionregions.service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "hello", description = "Les requetes possible sur ma table pays")
@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {




    /* Permet de creer une entrée pour*/
    private final PaysService paysService;
    @PostMapping("/create")
    @ApiOperation(value = "Permet de creer une entrée pour un pays")
    public Pays creer(@RequestBody Pays pays) {
        return paysService.creer(pays);
    }








    /*Permet d'afficher la liste de toute les  pays*/
    @GetMapping("/read")
    @ApiOperation(value = "Permet d'afficher la liste de toute les  pays")
    public List<Pays> lire() {
        return paysService.lire();
    }





    /*Permet de modifier un pays donné*/
    @PutMapping("/update/{idPays}")
    @ApiOperation(value = "Permet de modifier un pays donné")
    public Pays update(@PathVariable Long idPays, @RequestBody Pays pays) {
        return paysService.modifier(idPays,pays);
    }





    /*Permet de supprimer un pays donnée*/
    @DeleteMapping("/delete/{idPays}")
    @ApiOperation(value = "Permet de supprimer un pays donnée")
    public String supprimer(@PathVariable Long idPays) {
        return paysService.supprimer(idPays);
    }






}
