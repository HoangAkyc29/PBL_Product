package com.xadmin.productmanagement.bean;
import java.sql.Date;

public class Product 
{
	protected int ID_Product;
	protected int quantity;
	protected int price;
	protected float avarage_rating;
	protected String Product_description;
	
	protected String Book_title;
	protected String publisher;
	protected Date publish_date;
	protected int ID_Author;
	protected int ID_Category;
	
	
	
	public Product(int iD_Product, int quantity, int price, float avarage_rating,
			String product_description, String book_title, String publisher, Date publish_date,
			int iD_Author,int ID_Category) {
		super();
		this.ID_Product = iD_Product;
		this.quantity = quantity;
		this.price = price;
		this.avarage_rating = avarage_rating;
		Product_description = product_description;
		Book_title = book_title;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.ID_Author = iD_Author;
		this.ID_Category = ID_Category;
	}
	
	public Product(int quantity, int price, float avarage_rating, String product_description, String book_title, String publisher, Date publish_date, int iD_Author, int ID_Category) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.avarage_rating = avarage_rating;
		Product_description = product_description;
		Book_title = book_title;
		this.publisher = publisher;
		this.publish_date = publish_date;
		ID_Author = iD_Author;
		this.ID_Category = ID_Category;
	}

	public int getID_Product() {
		return ID_Product;
	}
	public void setID_Product(int iD_Product) {
		ID_Product = iD_Product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getAvarage_rating() {
		return avarage_rating;
	}
	public void setAvarage_rating(float avarage_rating) {
		this.avarage_rating = avarage_rating;
	}
	public String getProduct_description() {
		return Product_description;
	}
	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}
	public String getBook_title() {
		return Book_title;
	}
	public void setBook_title(String book_title) {
		Book_title = book_title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public int getID_Author() {
		return ID_Author;
	}
	public void setID_Author(int iD_Author) {
		ID_Author = iD_Author;
	}
	
	public int getID_Category() {
		return ID_Category;
	}

	public void setID_Category(int iD_Category) {
		ID_Category = iD_Category;
	}
}
