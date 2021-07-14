package springTutorial.northwind.business.abstracts;

import java.util.List;

import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;
import springTutorial.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
}
