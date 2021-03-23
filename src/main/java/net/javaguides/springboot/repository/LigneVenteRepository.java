package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.LigneVente;

public interface LigneVenteRepository extends JpaRepository <LigneVente,Integer>  {

}
