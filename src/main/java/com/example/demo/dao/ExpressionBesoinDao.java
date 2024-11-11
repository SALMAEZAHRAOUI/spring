package com.example.demo.dao;

import com.example.demo.bean.Compte;
import com.example.demo.bean.ExpressionBesoin;
import com.example.demo.bean.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpressionBesoinDao extends JpaRepository<ExpressionBesoin, Long> {
    ExpressionBesoin findByCode(String code);

    int deleteByCode(String code);


}
