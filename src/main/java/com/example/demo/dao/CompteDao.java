package com.example.demo.dao;

import com.example.demo.bean.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CompteDao extends JpaRepository<Compte, Long> {
    Compte findByRib(String rib );
     List<Compte> findBySoldeLessThan(double solde  );


}
