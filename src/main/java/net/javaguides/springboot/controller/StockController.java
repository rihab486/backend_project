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
import net.javaguides.springboot.model.Stock;
import net.javaguides.springboot.repository.StockRepository;



@RestController
@RequestMapping("/api/v1/")
//@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
	@Autowired
	private StockRepository stockRepository;
    // get all  Stock
	@GetMapping("/stock")
	public List<Stock> getAllStock(){
		return stockRepository.findAll();
	}
	// (post) create
				@PostMapping("/stock/new")
				public Stock createArticle(@RequestBody Stock s) {
					return stockRepository.save(s);
				}

				//get Stock by id restapi
				@GetMapping("/stock/new1/{id}")
				public ResponseEntity<Stock> getStockeById(@PathVariable Integer id) {
					Stock s = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock not exist with id :" + id));
					return ResponseEntity.ok(s);
				}
				//modifier Stock
				@PutMapping("/stock/{id}")
				public ResponseEntity<Stock> updateStock(@PathVariable Integer id, @RequestBody Stock stockeDetails){
					Stock s = stockRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Stock not exist with id :" + id));
					
					s.setCreationDate(stockeDetails.getCreationDate());
					s.setLastUpdateDate(stockeDetails.getLastUpdateDate());
					s.setDatemvt(stockeDetails.getDatemvt());
					s.setQuantite(stockeDetails.getQuantite());	
					Stock updatedStock = stockRepository.save(s);
					return ResponseEntity.ok(updatedStock);
					
				}
				// delete stock restAPI
				@DeleteMapping("/stock/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteArticle(@PathVariable Integer id){
					Stock s = stockRepository.findById(id)	
							.orElseThrow(() -> new ResourceNotFoundException("stck not exist with id :" + id));
					stockRepository.delete(s);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
		}

}
