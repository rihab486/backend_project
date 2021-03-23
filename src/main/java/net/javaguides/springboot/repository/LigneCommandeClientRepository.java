package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.LigneCommandeClient;

public interface LigneCommandeClientRepository extends JpaRepository <LigneCommandeClient,Integer> {

}
