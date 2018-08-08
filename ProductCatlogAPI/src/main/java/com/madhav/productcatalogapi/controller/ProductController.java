package com.madhav.productcatalogapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.madhav.productcatalogapi.productmodel.Product;
import com.madhav.productcatalogapi.repository.ProductRepository;

@RestController
@RequestMapping("/prodapi")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		
		List<Product> products = new ArrayList<Product>();
		//productRepo.findAll().forEach(products::add);
		Iterable<Product> iterableProduct  = productRepo.findAll();
		
		for(Product product: iterableProduct){
			product.add(linkTo(methodOn(ProductController.class).getProductById(product.getProductId())).withRel("detailpage"));
			products.add(product);
		}
		
		
		return new ResponseEntity<List<Product>>(products, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/product", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		try{
			Product savedProduct = productRepo.save(product);
			return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);	
		}catch(Exception ex){
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		
		Product product = productRepo.getProductByProductId(id);
		product.add(linkTo(methodOn(ProductController.class).getProductById(id)).withSelfRel());
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	
	}
	
}
