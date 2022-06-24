package com.xadmin.productmanagement.bean;

public class Rating 
{
	protected int ID_Rating;
	protected int ID_Customer;
	protected int ID_Product;
	protected int rating_star;
	protected String review_text;
	
	public Rating(int iD_Customer, int iD_Product, int rating_star, String review_text) {
		super();
		ID_Customer = iD_Customer;
		ID_Product = iD_Product;
		this.rating_star = rating_star;
		this.review_text = review_text;
	}
	public Rating(int iD_Rating, int iD_Customer, int iD_Product, int rating_star, String review_text) {
		super();
		ID_Rating = iD_Rating;
		ID_Customer = iD_Customer;
		ID_Product = iD_Product;
		this.rating_star = rating_star;
		this.review_text = review_text;
	}
	public int getID_Rating() {
		return ID_Rating;
	}
	public void setID_Rating(int iD_Rating) {
		ID_Rating = iD_Rating;
	}
	public int getID_Customer() {
		return ID_Customer;
	}
	public void setID_Customer(int iD_Customer) {
		ID_Customer = iD_Customer;
	}
	public int getID_Product() {
		return ID_Product;
	}
	public void setID_Product(int iD_Product) {
		ID_Product = iD_Product;
	}
	public int getRating_star() {
		return rating_star;
	}
	public void setRating_star(int rating_star) {
		this.rating_star = rating_star;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
}
