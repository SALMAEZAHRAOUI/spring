package com.example.demo.ws;

import com.example.demo.bean.Commande;
import com.example.demo.bean.Compte;
import com.example.demo.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("testcompte/compte")

public class CompteWs {
    @Autowired
   private CompteService compteService;
    @GetMapping("/rib/{rib}")
    public Compte findByrib(@PathVariable String rib) {
        return compteService.findByRib(rib);
    }
    @GetMapping("/solde/{solde}")
    public List<Compte> findBySoldeLessThan(@PathVariable double solde){
        return compteService.findBySoldeLessThan(solde);
    }
    @PatchMapping("/debiter/rib/{rib}/montant/{montant}")
    public int debiter( @PathVariable String rib,@PathVariable double montant){
        return compteService.debiter(rib,montant);
    }
    @PatchMapping("/crediter/rib/{rib}/montant/{montant}")
    public int crediter( @PathVariable String rib,@PathVariable double montant){
        return compteService.crediter(rib,montant);
    }
    @PatchMapping("/transferer/rib1/{rib1}/rib2/{rib2}/montant/{montant}")
    public int transferer( @PathVariable String rib1,@PathVariable String rib2,@PathVariable double montant){
        return compteService.transferer(rib1,rib2,montant);
    }

}
