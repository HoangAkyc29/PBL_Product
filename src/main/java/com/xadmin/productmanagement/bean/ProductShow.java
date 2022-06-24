package com.xadmin.productmanagement.bean;

import java.sql.Date;

public class ProductShow 
{
	protected int ID_Product;
	protected int quantity;
	protected int price;
	protected float avarage_rating;
	protected String Product_description = "No description here";
	
	protected String Book_title;
	protected String publisher;
	protected Date publish_date;
	protected String authorname;
	protected String category_name;
	
	public ProductShow(int iD_Product, int quantity, int price, float avarage_rating,
			String product_description, String book_title, String publisher, Date publish_date, String authorname,
			String category_name) {
		super();
		ID_Product = iD_Product;
		this.quantity = quantity;
		this.price = price;
		this.avarage_rating = avarage_rating;
		Product_description = product_description;
		Book_title = book_title;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.authorname = authorname;
		this.category_name = category_name;
	}

	public ProductShow(int quantity, int price, float avarage_rating, String product_description,
			String book_title, String publisher, Date publish_date, String authorname, String category_name) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.avarage_rating = avarage_rating;
		Product_description = product_description;
		Book_title = book_title;
		this.publisher = publisher;
		this.publish_date = publish_date;
		this.authorname = authorname;
		this.category_name = category_name;
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

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
