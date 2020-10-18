package com.zup.nossobancodigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.nossobancodigital.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
