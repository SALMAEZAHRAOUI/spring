package com.example.demo.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Compte {
    @Id
    @GeneratedValue
    private long id;
    private String rib;
    private  double solde;
    private boolean ouvert;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
}
