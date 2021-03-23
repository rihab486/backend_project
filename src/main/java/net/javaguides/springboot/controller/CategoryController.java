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
import net.javaguides.springboot.model.Category;
import net.javaguides.springboot.repository.CategoryRepository;

@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
    // get all category
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	// (post) create
				@PostMapping("/category/new")
				public Category createCategory(@RequestBody Category category) {
					return categoryRepository.save(category);
				}
	              //get category by id restapi
				@GetMapping("/category/new1/{id}")
				public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
					Category ca = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("article not exist with id :" + id));
					return ResponseEntity.ok(ca);
				}		
				
				//modifier category
				@PutMapping("/category/{id}")
				public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category CategoryDetails){
					Category ca = categoryRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Category not exist with id :" + id));
					
					ca.setCreationDate(CategoryDetails.getCreationDate());
					ca.setLastUpdateDate(CategoryDetails.getLastUpdateDate());
					ca.setCode(CategoryDetails.getCode());
					ca.setDesignation(CategoryDetails.getDesignation());
					
					Category updatedCategory = categoryRepository.save(ca);
					return ResponseEntity.ok(updatedCategory);
					
				}
				// delete article restAPI
				@DeleteMapping("/category/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteArticle(@PathVariable Integer id){
					Category ca = categoryRepository.findById(id)	
							.orElseThrow(() -> new ResourceNotFoundException("Category not exist with id :" + id));
					categoryRepository.delete(ca);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
		}
	
}
