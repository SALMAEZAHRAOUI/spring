package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
public class ExpressionBesoinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categorie;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQteDemande() {
        return qteDemande;
    }

    public void setQteDemande(int qteDemande) {
        this.qteDemande = qteDemande;
    }

    public int getQteConfirme() {
        return qteConfirme;
    }

    public void setQteConfirme(int qteConfirme) {
        this.qteConfirme = qteConfirme;
    }

    public int getQteLivre() {
        return qteLivre;
    }

    public void setQteLivre(int qteLivre) {
        this.qteLivre = qteLivre;
    }

    public int getQtepaye() {
        return qtepaye;
    }

    public void setQtepaye(int qtepaye) {
        this.qtepaye = qtepaye;
    }

    public ExpressionBesoin getExpressionBesoin() {
        return expressionBesoin;
    }

    public void setExpressionBesoin(ExpressionBesoin expressionBesoin) {
        this.expressionBesoin = expressionBesoin;
    }

    private int qteDemande;
    private int qteConfirme;
    private int qteLivre;
    private int qtepaye;

    @ManyToOne
    @JoinColumn(name = "expression_besoin_id")
    private ExpressionBesoin expressionBesoin;

}
