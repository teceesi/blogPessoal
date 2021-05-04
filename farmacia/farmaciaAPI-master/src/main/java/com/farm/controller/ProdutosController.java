package com.farm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farm.model.ProdutosModel;
import com.farm.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutosController {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutosModel> GetById(@PathVariable long id){
		return produtosRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
		
	@PostMapping
	public ResponseEntity<ProdutosModel> criarProduto(@RequestBody ProdutosModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutosModel> atualizarProduto(@RequestBody ProdutosModel produto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtosRepository.deleteById(id);
	}
	
	
}
