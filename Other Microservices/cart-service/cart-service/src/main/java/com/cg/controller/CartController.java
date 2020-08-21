package com.cg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Cart;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.repository.CartRepository;
import com.cg.repository.ProductRepository;
import com.cg.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
//@Api(value = "CartController using logger and swagger")
@RequestMapping("/api")
public class CartController {
	@Autowired
	CartRepository repository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(CartController.class);

	@GetMapping(path = "/getCart")

//	@ApiOperation(value = "To fetch the cart", nickname = "To fetch the cart")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Cart.class),
//			@ApiResponse(code = 500, message = "Failure", response = Cart.class) })

	public List<Cart> retriveAllProducts() {
		System.out.println("Inside retriveAllProducts() of Controller");
		return repository.findAll();
	}

	@PostMapping(path = "/add")
	public void add(@RequestParam("email") String email, @RequestParam("quantity") int quantity,
			@RequestParam("productId") int productId) {
		System.out.println("Inside add() of Controller");
		// repository.save(product);
		Product product = productRepository.getOne(productId);
		double productPrice = product.getProductPrice();
		String productName = product.getProductName();
		User user = userRepository.findByemail(email);
		System.out.println(product);
		System.out.println(user);
		System.out.println(user.toString());
		Cart cart = new Cart(quantity, productPrice, productName, product, user);
		repository.save(cart);

	}

	@DeleteMapping(path = "/delete/{id}")
	public List<Cart> delete(@PathVariable int id) {
		System.out.println("Inside delete() of Controller");
		repository.deleteById(id);
		return repository.findAll();
	}

	@GetMapping(path = "/findById/{id}")
	public List<Cart> findById(@PathVariable int id) {
		System.out.println("inside findById of Controller");
		return repository.findAll().stream().filter(pro -> pro.getUser().getUserId() == id)
				.collect(Collectors.toList());
	}

}
