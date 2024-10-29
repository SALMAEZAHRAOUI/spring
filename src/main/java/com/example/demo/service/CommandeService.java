package com.example.demo.service;

import com.example.demo.bean.Commande;
import com.example.demo.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandedao;

    public Commande findByRef(String ref) {
        return commandedao.findByRef(ref);
    }

    @Transactional
    public Commande deleteByRef(String ref) {
        return commandedao.deleteByRef(ref);
    }

    @Deprecated
    public Commande getOne(Long aLong) {
        return commandedao.getOne(aLong);
    }

    public List<Commande> findByRefLikeAndTotalGreaterThan(String ref, double total) {
        return commandedao.findByRefLikeAndTotalGreaterThan(ref, total);
    }

    public List<Commande> findAll() {
        return commandedao.findAll();
    }


    public int save (Commande commande){
if (findByRef (commande.getRef())!=null) {
        return -1;
    }else if(commande.getTotal() <commande.getTotalPaye()){
        return -2;
    }else {
    commandedao.save(commande);
    return 1;
}
    }


    public int payer (String ref, double mt){
        Commande commande = findByRef(ref);
        if (commande==null){
            return -1;
        }else if(commande.getTotalPaye()+mt>commande.getTotal()){
            return -2;
        }else{
            double nvTotalPaye=commande.getTotalPaye()+mt; commande.setTotalPaye (nvTotalPaye); commandedao.save(commande);
            return 1;
        }
}

}


