package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.CommandeFournisseur;

public interface CommandeFournisseurRepository extends  JpaRepository<CommandeFournisseur,Integer> {

}
