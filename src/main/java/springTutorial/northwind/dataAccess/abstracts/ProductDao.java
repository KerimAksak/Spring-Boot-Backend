package springTutorial.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springTutorial.northwind.entities.concretes.Product;
import springTutorial.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	// getBy or findBy
	
	Product getByProductName(String productName);
	
	Product getByProductId(int productId);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	// It can return single or multiple data according to the return type.
	
	// SELECT * FROM Product WHERE productName="abc" and categoryId="1"
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	// SELECT * FROM Product WHERE categoryId in(1,2,10)
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	// @Query; All content should be made according to Entity naming. Not based on database naming.
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	// SELECT * FROM product WHERE productName="abc" and categoryId=2
	
	// SELECT p.productId, p.productName, c.categoryName FROM Category as c inner join Product as p
	// on c.categoryId = p.categoryId;
	@Query("Select new springTutorial.northwind.entities.dtos.ProductWithCategoryDto(p.productId, p.productName, c.categoryName) "
			+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();

}




