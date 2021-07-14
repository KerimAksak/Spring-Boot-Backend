package springTutorial.northwind.business.abstracts;

import java.util.List;

import springTutorial.northwind.entities.concretes.Product;

public interface ProductService {
	List<Product> getAll();
}
