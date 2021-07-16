package springTutorial.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springTutorial.northwind.business.abstracts.ProductService;
import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;
import springTutorial.northwind.core.utilities.results.SuccessDataResult;
import springTutorial.northwind.core.utilities.results.SuccessResult;
import springTutorial.northwind.dataAccess.abstracts.ProductDao;
import springTutorial.northwind.entities.concretes.Product;
import springTutorial.northwind.entities.dtos.ProductWithCategoryDto;

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

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.prodactDao.getByProductName(productName),
				"Data listelendi.");
	}
	
	@Override
	public DataResult<Product> getByProductId(int productId) {
		return new SuccessDataResult<Product>(this.prodactDao.getByProductId(productId),
				"Data listelendi.");
	}
	
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.prodactDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.prodactDao.getByProductNameOrCategory_CategoryId(productName, categoryId),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.prodactDao.getByCategoryIn(categories),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.prodactDao.getByProductNameContains(productName),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.prodactDao.getByProductNameStartsWith(productName),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.prodactDao.getByNameAndCategory(productName, categoryId),
				"Data listelendi.");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		return new SuccessDataResult<List<Product>>(this.prodactDao.findAll(pageable).getContent()); 
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>>(this.prodactDao.findAll(sort), "Başarılı.");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.prodactDao.getProductWithCategoryDetails(),
				"Data listelendi.");
	}

}




