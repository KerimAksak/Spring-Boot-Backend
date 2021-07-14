package springTutorial.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import springTutorial.northwind.business.abstracts.ProductService;
import springTutorial.northwind.dataAccess.abstracts.ProductDao;
import springTutorial.northwind.entities.concretes.Product;

public class ProductManager implements ProductService {

	// Constructor Injection; We removed the dependency on DataAccess. (tightly)
	private ProductDao prodactDao;
	
	// @Autowired; Since productDao is an interface, Autowired creates a corresponding class.
	@Autowired
	public ProductManager(ProductDao prodactDao) {
		super();
		this.prodactDao = prodactDao;
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
