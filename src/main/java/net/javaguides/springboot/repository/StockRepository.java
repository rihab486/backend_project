package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Stock;

public interface StockRepository extends JpaRepository <Stock,Integer> {

}
