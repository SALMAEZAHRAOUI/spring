package com.example.demo.dao;

import com.example.demo.bean.Compte;
import com.example.demo.bean.EtatExpressionBesoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatExpressionBesoinDao extends JpaRepository<EtatExpressionBesoin, Long> {



}
