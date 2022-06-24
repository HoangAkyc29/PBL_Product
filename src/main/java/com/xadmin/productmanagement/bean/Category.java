package com.xadmin.productmanagement.bean;

public class Category 
{
	private int ID_Category;
	private String category_name;
	private String description = "";
	
	public int getID_Category() {
		return ID_Category;
	}
	public void setID_Category(int iD_Category) {
		ID_Category = iD_Category;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Category(int iD_Category, String category_name, String description) {
		super();
		ID_Category = iD_Category;
		this.category_name = category_name;
		this.description = description;
	}
	public Category(String category_name, String description) {
		super();
		this.category_name = category_name;
		this.description = description;
	}
	
	
}
