package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Article;
public interface ArticleRepository extends JpaRepository <Article,Integer> {

}
