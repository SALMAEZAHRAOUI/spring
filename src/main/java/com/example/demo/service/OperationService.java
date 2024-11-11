package com.example.demo.service;

import com.example.demo.bean.Compte;
import com.example.demo.bean.Operation;
import com.example.demo.bean.TypeOperation;
import com.example.demo.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OperationService {

    public static final String CREDIT = "credit";
    public static final String DEBIT = "debit";
    @Autowired
    private OperationDao dao;
    @Autowired
    private CompteService compteService;
    @Autowired
    private TypeOperationService typeOperationService;

    public int save(Operation operation) {
        Compte compte = compteService.findByRib(operation.getCompte().getRib());
        operation.setCompte(compte);
        TypeOperation typeOperation = typeOperationService.findByCode(operation.getTypeOperation().getCode());
        operation.setTypeOperation(typeOperation);

        if (compte == null) {
            return -1;
        } else if (findByCode(operation.getCode()) != null) {
            return -2;
        } else if (typeOperation != null && typeOperation.getCode().equals(CREDIT) && compte.getSolde() < operation.getMontant()) {
            return -3;
        } else {
            if (typeOperation.getCode().equals(CREDIT)) {
                double nvSolde = compte.getSolde() - operation.getMontant();
                compte.setSolde(nvSolde);
                compteService.update(compte);
                dao.save(operation);
                return 1;
            } else {
                double nvSolde = compte.getSolde() + operation.getMontant();
                compte.setSolde(nvSolde);
                compteService.update(compte);
                dao.save(operation);
                return 2;
            }
        }
    }


    public int cancel(String code){
        Operation operation = findByCode(code);
        if (operation == null) {
            return -1;
        }else{
            Operation inverseOperation = constructInverse(operation);
            return save(inverseOperation);
        }
    }

    private Operation constructInverse(Operation operation) {
        Operation inverse = new Operation();
        inverse.setCode(UUID.randomUUID().toString());
        TypeOperation debit = typeOperationService.findByCode(DEBIT);
        TypeOperation credit = typeOperationService.findByCode(CREDIT);
        if (operation.getTypeOperation().getCode().equals(CREDIT)) {
            operation.setTypeOperation(debit);
        }else{
            operation.setTypeOperation(credit);
        }
        inverse.setTypeOperation(operation.getTypeOperation());
        inverse.setMontant(operation.getMontant());
        inverse.setCompte(operation.getCompte());
        return inverse;

    }

    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    public List<Operation> findByCompteRib(String rib) {
        return dao.findByCompteRib(rib);
    }

    @Transactional
    public int deleteByCompteRib(String rib) {
        return dao.deleteByCompteRib(rib);
    }

    public Operation findByCode(String code) {
        return dao.findByCode(code);
    }

    public List<Operation> findAll() {
        return dao.findAll();
    }

}
