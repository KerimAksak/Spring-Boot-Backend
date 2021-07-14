package springTutorial.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Product", schema = "Northwind")
public class Product {
	
	// For MySql take in mind that it's not a good idea to write camelcase. 
	// You must be very careful cause isActive column will translate to isactive. 
	// *** productId --> productid
	
	@Id
	@GeneratedValue
	@Column(name="productid")
	private int id;
	
	@Column(name="categoryid")
	private int categoryId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="unitprice")
	private double unitPrice; 
	
	@Column(name="unitsinstock")
	private short unitsInStock;
	
	@Column(name="quantityperunit")
	private String quantityPerUnit;
	
	public Product() {};
	
	public Product(int id, int categoryId, String productName, double unitPrice, short unitsInStock,
			String quantityPerUnit) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

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
