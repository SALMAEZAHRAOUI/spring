package com.example.demo.bean;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ExpressionBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String libelle;
    private String description;
    private String departement;
    private String demendeur;
    private String code;
    private Date date;



    @OneToMany(mappedBy = "expressionBesoin")
    private List<EtatExpressionBesoin> etats;

    @OneToMany(mappedBy = "expressionBesoin")
    private List<ExpressionBesoinItem> items;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getDemendeur() {
        return demendeur;
    }

    public void setDemendeur(String demendeur) {
        this.demendeur = demendeur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<EtatExpressionBesoin> getEtats() {
        return etats;
    }

    public void setEtats(List<EtatExpressionBesoin> etats) {
        this.etats = etats;
    }

    public List<ExpressionBesoinItem> getItems() {
        return items;
    }

    public void setItems(List<ExpressionBesoinItem> items) {
        this.items = items;
    }
}
