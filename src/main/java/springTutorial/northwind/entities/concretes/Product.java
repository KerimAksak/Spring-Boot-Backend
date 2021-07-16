package springTutorial.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Product", schema = "Northwind")
public class Product {
	
	// For MySql take in mind that it's not a good idea to write camelcase. 
	// You must be very careful cause isActive column will translate to isactive. 
	// *** productId --> productid
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productid")
	private int productId;
	
	//@Column(name="categoryid")
	//private int categoryId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="unitprice")
	private double unitPrice; 
	
	@Column(name="unitsinstock")
	private short unitsInStock;
	
	@Column(name="quantityperunit")
	private String quantityPerUnit;
	
	
	// The relation between Product and Category is made over categoryId.
	// That's why a join operation is performed with categoryId to ensure the relationship in the Product.
	// It's as if there is no need to write categoryId in the Product again, as it places the Category columns in the Product.
	@ManyToOne()
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Product() {};
	
	public Product(int productId, String productName, double unitPrice, short unitsInStock,
			String quantityPerUnit) {
		super();
		this.productId = productId;
		//this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getId() {
		return productId;
	}

	public void setId(int productId) {
		this.productId = productId;
	}
	/*
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	*/
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	
	
}
