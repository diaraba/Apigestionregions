package com.apigestionregions.Apigestionregions.repository;

import com.apigestionregions.Apigestionregions.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaysRepository extends JpaRepository<Pays, Long> {
  /*  @Query(value = "SELECT regions.nom, population.annee, population.nb_habitant FROM pays,regions,population WHERE regions.id_pays =pays.id AND population.regions_id = regions.id AND regions.nom =:regions", nativeQuery = true )
    public Iterable<Object[]> FIND_PAYS_REGION_POPULATION_ANNEE_NBHABUTANT(String regions);*/

 Pays findByNompays(String nompays);
}
