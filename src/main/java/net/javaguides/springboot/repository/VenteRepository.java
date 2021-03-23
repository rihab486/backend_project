package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Vente;

public interface VenteRepository extends JpaRepository <Vente,Integer> {

}
