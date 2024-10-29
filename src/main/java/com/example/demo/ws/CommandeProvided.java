package com.example.demo.ws;


import com.example.demo.bean.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("gestion-commercial/commande")
public class CommandeProvided {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public Commande deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }

    @GetMapping("/id/{id}")
    public Commande getOne(@PathVariable Long id) {
        return commandeService.getOne(id);
    }

    @GetMapping("/ref/{ref}/total/{total}")
    public List<Commande> findByRefLikeAndTotalGreaterThan(@PathVariable String ref, @PathVariable double total) {
        return commandeService.findByRefLikeAndTotalGreaterThan(ref, total);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @PostMapping("/")

    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping("/payer/ref/{ref}/mt/{mt}")
    public int payer(@PathVariable String ref, @PathVariable double mt) {
        return commandeService.payer(ref, mt);
    }
}

