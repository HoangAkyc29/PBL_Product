package com.xadmin.productmanagement.bean;

import java.sql.Date;

public class Author 
{
	private int ID_Author;
	private String authorname;
	private Date dateofbirth;
	private String description = "";
	
	public Author(int iD_Author, String authorname, Date dateofbirth, String description) {
		super();
		ID_Author = iD_Author;
		this.authorname = authorname;
		this.dateofbirth = dateofbirth;
		this.description = description;
	}

	public Author(String authorname, Date dateofbirth, String description) {
		super();
		this.authorname = authorname;
		this.dateofbirth = dateofbirth;
		this.description = description;
	}

	public int getID_Author() {
		return ID_Author;
	}

	public void setID_Author(int iD_Author) {
		ID_Author = iD_Author;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
