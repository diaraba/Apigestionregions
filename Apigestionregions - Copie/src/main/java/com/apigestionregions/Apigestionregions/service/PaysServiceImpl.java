package com.apigestionregions.Apigestionregions.service;

import com.apigestionregions.Apigestionregions.modele.Pays;
import com.apigestionregions.Apigestionregions.repository.PaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService{
    private final PaysRepository paysRepository;
    @Override
    public Pays creer(Pays pays) {
            return paysRepository.save(pays); /*C'est  l'implementation de la méthode permettant de creer un pays*/
    }

    @Override
    public List<Pays> lire() {
        return paysRepository.findAll();
    }/*C'est  l'implementation de la méthode permettant d'afficher une liste des pays créer*/

    @Override
    public Pays modifier(Long idPays, Pays pays) {/*C'est l'implementation de la méthode permettant de modifier un pays*/
        return paysRepository.findById(idPays)
                .map(pays1 -> {
                    pays1.setNompays(pays.getNompays());
                    return paysRepository.save(pays1);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
    }

    @Override
    public Pays getNompays(Pays pays) {
        return paysRepository.findByNompays(pays.getNompays());
    }

    @Override
    public String supprimer(Long idPays) {/*C'est l'implementation de la méthode permettant de supprimer un pays*/
        paysRepository.deleteById(idPays);
        return "Pays supprimer";
    }
}
