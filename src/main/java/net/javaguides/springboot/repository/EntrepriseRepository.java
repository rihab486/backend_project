package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository <Entreprise,Integer> {

}
