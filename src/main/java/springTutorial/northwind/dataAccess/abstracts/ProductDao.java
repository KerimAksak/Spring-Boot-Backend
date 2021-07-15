package springTutorial.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springTutorial.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	// getBy or findBy
	
	Product getByProductName(String productName);
	
	Product getByProductId(int productId);
	
	Product getByProductNameAndCategoryId(String productName, int categoryId);

	// It can return single or multiple data according to the return type.
	
	// SELECT * FROM Product WHERE productName="abc" and categoryId="1"
	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
	
	// SELECT * FROM Product WHERE categoryId in(1,2,10)
	List<Product> getByCategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	// @Query; All content should be made according to Entity naming. Not based on database naming.
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	// SELECT * FROM product WHERE productName="abc" and categoryId=2

}