package com.example.demo.dao;

import com.example.demo.bean.Compte;
import com.example.demo.bean.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<Operation,Long> {
    Operation findByCode(String code );


}
