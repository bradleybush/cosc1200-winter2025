// Demo

// Package
package demos.week4.productdemo;

// Imports
import java.util.Date;

public class Product
{
	// Attributes
	private int productId;
	private String productName;
	private double productPrice;
	private Date productionDate;
	private Date expiryDate;
	private int productQuantity;
	public static final String MANUFACTURER_NAME = "BMW";
	
	// Default constructor
	public Product() {}
	
	// Parameterized constructor
	public Product(int productId, String productName, double productPrice, Date productionDate, Date expiryDate, int productQuantity)
	{
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productionDate = productionDate;
		this.expiryDate = expiryDate;
		this.productQuantity = productQuantity;
	}
	
	public int getProductQuantity()
	{
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity = productQuantity;
	}
	
	public Date getExpiryDate()
	{
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}
	
	public Date getProductionDate()
	{
		return productionDate;
	}
	public void setProductionDate(Date productionDate)
	{
		this.productionDate = productionDate;
	}
	
	public double getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(double productPrice)
	{
		this.productPrice = productPrice;
	}
	
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public int getProductId()
	{
		return productId;
	}
	public void setProductId(int productId)
	{
		this.productId = productId;
	}
	
	public void printProductDescription()
	{
		System.out.println("Product ID: " + this.productId);
		System.out.println("Product Name: " + this.productName);
		System.out.println("Product Price: " + this.productPrice);
		System.out.println("Product Date: " + this.productionDate);
		System.out.println("Product Expiry Date: " + this.expiryDate);
		System.out.println("Product Quantity: " + this.productQuantity);
	}
}
