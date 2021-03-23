package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Article;
import net.javaguides.springboot.repository.ArticleRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController  {
	@Autowired
	private ArticleRepository articleRepository;
    // get all article
	@GetMapping("/article")
	public List<Article> getAllArticle(){
		return articleRepository.findAll();
	}
	// (post) create
				@PostMapping("/article/new")
				public Article createArticle(@RequestBody Article article) {
					return articleRepository.save(article);
				}

				//get client by id restapi
				@GetMapping("/article/new1/{id}")
				public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
					Article artilce = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
					return ResponseEntity.ok(artilce);
				}
				//modifier article
				@PutMapping("/article/{id}")
				public ResponseEntity<Article> updateArticle(@PathVariable Integer id, @RequestBody Article articleDetails){
					Article article = articleRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
					
					article.setCreationDate( articleDetails.getCreationDate());
					article.setLastUpdateDate( articleDetails.getLastUpdateDate());
					article.setCodeArticle( articleDetails.getCodeArticle());
					article.setDesignation( articleDetails.getDesignation());
					article.setPrixYnitaireHt( articleDetails.getPrixYnitaireHt());

				
					Article updatedArticle = articleRepository.save(article);
					return ResponseEntity.ok(updatedArticle);
					
				}
				// delete article restAPI
				@DeleteMapping("/article/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteArticle(@PathVariable Integer id){
					Article article = articleRepository.findById(id)	
							.orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
					articleRepository.delete(article);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
		}
}

