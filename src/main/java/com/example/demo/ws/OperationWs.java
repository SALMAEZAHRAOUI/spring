package com.example.demo.ws;



import com.example.demo.bean.Operation;
import com.example.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationWs {

    @Autowired
    OperationService operationService;

    @PostMapping("")
    public int save(@RequestBody Operation operation) {
        return operationService.save(operation);
    }

    @PostMapping("cancel/code/{code}")
    public int cancel(@PathVariable("code") String code) {
        return operationService.cancel(code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable("code") String code) {
        return operationService.deleteByCode(code);
    }

    @GetMapping("/rib/{rib}")
    public List<Operation> findByCompteRib(@PathVariable("rib") String rib) {
        return operationService.findByCompteRib(rib);
    }

    @DeleteMapping("rib/{rib}")
    public int deleteByCompteRib(@PathVariable("rib") String rib) {
        return operationService.deleteByCompteRib(rib);
    }

    @GetMapping("code/{code}")
    public Operation findByCode(@PathVariable("code") String code) {
        return operationService.findByCode(code);
    }

    @GetMapping("")
    public List<Operation> findAll() {
        return operationService.findAll();
    }
}

