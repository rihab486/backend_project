package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Client;

public interface ClientRepository extends JpaRepository <Client,Integer> {

}
