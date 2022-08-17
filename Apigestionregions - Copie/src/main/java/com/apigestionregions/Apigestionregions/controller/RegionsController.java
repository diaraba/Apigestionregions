package com.apigestionregions.Apigestionregions.controller;

import com.apigestionregions.Apigestionregions.modele.Pays;
import com.apigestionregions.Apigestionregions.modele.Population;
import com.apigestionregions.Apigestionregions.modele.Regions;
import com.apigestionregions.Apigestionregions.service.PaysService;
import com.apigestionregions.Apigestionregions.service.PopulationService;
import com.apigestionregions.Apigestionregions.service.RegionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "hello", description = "Les requetes possible sur ma table regions")
@RestController
@RequestMapping("/regions")
@AllArgsConstructor
public class RegionsController {
    private final RegionsService regionsService;
    private final PaysService paysService;







    /*Permet creer une entrée pour */
    @PostMapping("/create")
    @ApiOperation(value = "Permet creer une entrée pour")
    public String creer(@RequestBody Regions regions) {
        regionsService.creer(regions);

        return "La population a été ajouté avec succcès";
    }






    /*Permet d'afficher la liste de toute les regions avec tout les chanmps de notre entités region */
    @GetMapping("/read")
    @ApiOperation(value = "Permet d'afficher la liste de toute les regions avec tout les chanmps de notre entités region ")
    public Iterable<Object[]> lire() {
        return regionsService.lire();
    }







    /*Permet d'afficher la liste de toute les regions sans le pays */
    @GetMapping("/read1")
    @ApiOperation(value = "Permet d'afficher la liste de toute les regions sans le pays")
    public Iterable<Object[]> lireFIND_REGION_SANS_Pays() {
        return regionsService.lireFIND_REGION_SANS_Pays();
    }







    /*Permet d'afficher la liste de toute les regions en fonction du pays */
    @GetMapping("/read2/{pays}")
    @ApiOperation(value = "Permet d'afficher la liste de toute les regions en fonction du pays ")
    public Iterable<Object[]> lireFIND_REGION_EN_FONCTION_DU_Pays(@PathVariable String pays) {
        return regionsService.lireFIND_REGION_EN_FONCTION_DU_Pays(pays);
    }






    /*Permet d'afficher la liste de toute les regions avec le pays correspondante */
    @GetMapping("/read3")
    @ApiOperation(value = "Permet d'afficher la liste de toute les regions avec le pays correspondante ")
    public Iterable<Object[]> lireFIND_ALLREGION_WITH_PAYS() {
        return regionsService. lireFIND_ALLREGION_WITH_PAYS();
    }









    /*Permet d'afficher la liste de toute les entrée d'une region donné avec le nombre d'habitant avec l'année correspondante */
    @GetMapping("/read4/{regions}")
    @ApiOperation(value = "Permet d'afficher la liste de toute les entrée d'une region donné avec le nombre d'habitant avec l'année correspondante")
    public Iterable<Object[]> lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(@PathVariable String regions) {
        return regionsService.lireFIND_REGION_POPULATION_ANNEE_NBHABUTANT(regions);
    }








    /*Permet de modifier une regions donnée*/
    @PutMapping("/update/{idRegions}")
    @ApiOperation(value = "Permet de modifier une regions donnée")
    public Regions update(@PathVariable Long idRegions, @RequestBody Regions regions) {
        return regionsService.modifier(idRegions,regions);
    }






    /*Permet de supprimer une regions donnée*/
    @ApiOperation(value = "Permet de supprimer une regions donnée")
    @DeleteMapping("/delete/{idRegions}")
    public String supprimer(@PathVariable Long idRegions) {
        return regionsService.supprimer(idRegions);
    }






    @ApiOperation(value="Cette méthode nous permet d'ajouter la region et le pays si le pays n'exite pas")
    @PostMapping("/create2")
    public Regions creer_regions_pays(@RequestBody Regions regions)
    {
        Pays PaysIsPresente = paysService.getNompays(regions.getPays());
        if(PaysIsPresente==null)
        {
           paysService.creer(regions.getPays()) ;

        }
        return regionsService.creer(regions);
    }

}

