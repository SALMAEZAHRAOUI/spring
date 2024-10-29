package com.example.demo.bean;

import jakarta.persistence.*;

import java.sql.ClientInfoStatus;
import java.util.List;

@Entity
public class TypeOperation {
    @Id
    @GeneratedValue
    private long id;
    private String libelle;
    private String code;
    @OneToMany
    private List<Operation> operations;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
