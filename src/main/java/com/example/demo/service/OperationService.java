package com.example.demo.service;

import com.example.demo.bean.Compte;
import com.example.demo.bean.Operation;
import com.example.demo.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    private OperationDao operationDao;
    public Operation findByCode(String code){
        return operationDao.findByCode(code);
    }


}
