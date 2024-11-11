package com.example.demo.dao;

import com.example.demo.bean.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationDao extends JpaRepository<TypeOperation, Long> {

    TypeOperation  findByCode (String code);
    int  deleteByCode(String code);

}
