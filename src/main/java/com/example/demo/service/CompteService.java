package com.example.demo.service;

import com.example.demo.bean.Compte;
import com.example.demo.dao.CompteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteDao compteDao;

    public Compte findByRib(String rib) {
        return compteDao.findByRib(rib);
    }

    public List<Compte> findBySoldeLessThan(double solde) {
        return compteDao.findBySoldeLessThan(solde);
    }

    public int debiter(String rib, double montant) {
        Compte compte = findByRib(rib);
        if (compte == null) {
            return -1;
        } else if (!compte.isOuvert()) {
            return -2;
        } else {
            compte.setSolde(compte.getSolde() + montant);
            compteDao.save(compte);
            return 1;
        }

    }

    public int crediter(String rib, double montant) {
        Compte compte = findByRib(rib);
        if (compte == null) {
            return -1;
        } else if (!compte.isOuvert()) {
            return -2;
        } else if (compte.getSolde() < montant) {
            return -3;

        } else {
            compte.setSolde(compte.getSolde() - montant);
            compteDao.save(compte);
            return 1;
        }
    }

    public int transferer(String ribSource, String ribDestination, double montant) {
        Compte compte1 = findByRib(ribSource);
        Compte compte2 = findByRib(ribDestination);

        if (compte1 == null || compte2 == null) {
            return -1;
        } else if (!compte1.isOuvert() || !compte2.isOuvert()) {
            return -2;
        } else if (compte1.getSolde() < montant) {
            return -3;
        } else {
            compte2.setSolde(compte2.getSolde() + montant);
            compte1.setSolde(compte1.getSolde() - montant);
            compteDao.save(compte1);
            compteDao.save(compte2);
            return 1;
        }
    }
    public int ouvrir ( String rib){
      Compte compte = findByRib(rib);
        if (compte == null) {
            return -1;
        } else if (!compte.isOuvert()) {
            return -2;
        } else if (compte.getSolde()<0 ) {
            return -3;
        }
        else {
            compteDao.save(compte);
        return 1;}
    }


    public void update(Compte compte) {
    }
}
