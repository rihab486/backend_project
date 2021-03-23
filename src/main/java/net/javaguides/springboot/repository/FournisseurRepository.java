package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository <Fournisseur,Integer> {

}
