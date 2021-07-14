package springTutorial.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springTutorial.northwind.business.abstracts.ProductService;
import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;
import springTutorial.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
// domain/api/products
public class ProductsController {
	
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	};
	
	// @PostMapping; It matches the product class.
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	
}
