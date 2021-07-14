package springTutorial.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springTutorial.northwind.business.abstracts.ProductService;
import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;
import springTutorial.northwind.core.utilities.results.SuccessDataResult;
import springTutorial.northwind.core.utilities.results.SuccessResult;
import springTutorial.northwind.dataAccess.abstracts.ProductDao;
import springTutorial.northwind.entities.concretes.Product;

// In addition, we specify that this class is the service layer.
@Service
public class ProductManager implements ProductService {

	// Dependency Injection & Constructor Injection; We removed the dependency on DataAccess. (tightly)
	private ProductDao prodactDao;
	
	// @Autowired; Since productDao is an interface, Autowired creates a corresponding class.
	@Autowired
	public ProductManager(ProductDao prodactDao) {
		super();
		this.prodactDao = prodactDao;
	}
	
	@Override
	public DataResult<List<Product>> getAll() {
	// DataResult&Result = Super Type
	// Using the DataResult interface we can return both SuccessDataResult and ErrorDataResult.
		return new SuccessDataResult<List<Product>>(this.prodactDao.findAll(),
				"Data listelendi.");
	}

	@Override
	public Result add(Product product) {
		this.prodactDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

}
