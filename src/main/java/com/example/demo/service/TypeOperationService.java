package com.example.demo.service;

import com.example.demo.bean.TypeOperation;
import com.example.demo.dao.TypeOperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOperationService {
    @Autowired
    private TypeOperationDao dao;

    public TypeOperation findByCode(String code) {
        return dao.findByCode(code);
    }

    public List<TypeOperation> findAll() {
        return dao.findAll();
    }

}
