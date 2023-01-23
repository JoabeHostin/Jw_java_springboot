package com.jw.jw_mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jw.jw_mecanica.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

    
    

