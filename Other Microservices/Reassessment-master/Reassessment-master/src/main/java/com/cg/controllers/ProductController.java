package com.cg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.models.Product;
import com.cg.service.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
//@Api(value = "ProductController using logger and swagger")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductServiceImpl service;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping(path = "/getProducts")

//	@ApiOperation(value = "retrieveLimitsFromConfigurations", nickname = "retrieveLimitsFromConfigurations")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
//			@ApiResponse(code = 500, message = "Failure", response = Product.class) })

	public List<Product> retriveAllProducts() {
		System.out.println("Inside retriveAllProducts() of Controller");
		logger.info("Sample logging");
		return service.retriveAllProducts();
	}

	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Product product) {
		System.out.println("Inside add() of Controller");
		service.add(product);
	}

	@DeleteMapping(path = "/delete/{id}")
	public List<Product> delete(@PathVariable int id) {
		System.out.println("Inside delete() of Controller");
		service.delete(id);
		return service.retriveAllProducts();

	}

	@PutMapping(path = "/update/{productId}")
	public Product editProduct(@Valid @PathVariable int productId, @RequestBody Product product) {

		return service.editProduct(product);

	}
}
