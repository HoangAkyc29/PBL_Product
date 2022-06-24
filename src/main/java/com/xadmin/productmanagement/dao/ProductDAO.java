package com.xadmin.productmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.productmanagement.bean.*;

public class ProductDAO 
{
	private String url = "jdbc:mysql://localhost:3306/?user=root";
	private String Driver = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "";
	
	private static String INSERT_PRODUCT_SQL = "Insert INTO product " + 
	"(quantity, price, avarage_rating, Product_description, Book_title, Publisher, publish_date, ID_Author, ID_Category) VALUES "
	+ " (?,?,?,?,?,?,?,?,?);";
	private static String SELECT_ALL_PRODUCT = "SELECT * FROM product";
	private static String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE ID_Product = ?";
	private static String SELECT_PRODUCT_BY_Category = "SELECT * FROM product WHERE ID_Category = ?";
	private static String DELETE_PRODUCT_SQL = "delete from product where ID_Product = ? ;";
	private static String UPDATE_PRODUCT_SQL = "update product set "
			+ "quantity = ?, "
			+ "price = ?, "
			+ "avarage_rating = ?, "
			+ "Product_description = ?, "
			+ "Book_title = ?, "
			+ "publisher = ?, "
			+ "publish_date = ?, "
			+ "ID_Author = ?, " 
			+ "ID_Category = ? " 
			+ "where ID_Product = ?;";
	
	private static String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE ID_Category = ?";
	private static String SELECT_AUTHOR_BY_ID = "SELECT * FROM author WHERE ID_Author = ?";
	//private static String SELECT_CATEGORYNAME_BY_ID = "SELECT categoryname FROM Category WHERE ID_Category = ?";
	private static String SELECT_ALL_CATEGORY = "SELECT * FROM category";
	private static String SELECT_ALL_AUTHOR = "SELECT * FROM author";
	
	private static String INSERT_AUTHOR_SQL = "Insert INTO author "
			+ "(authorname,dateofbirth,description) "
			+ "(?,?,?);";
	
	private static String SELECT_RATING_BY_ID_PRODUCT = "SELECT * FROM rating WHERE ID_Product = ? ";
	private static String INSERT_RATING_SQL = "Insert INTO rating "
			+ "(ID_Customer,ID_Product,rating_star,review_text) "
			+ "(?,?,?,?);";
	//private static String SELECT_//
	
	public ProductDAO()
	{
		
	}
	protected Connection getConnection()
	{
		Connection connection = null;
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(url, username, password);
			Statement stmt = connection.createStatement();
			String use = "use onlinebook";
			stmt.executeUpdate(use);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void insertProduct(Product Product) throws SQLException {
		System.out.println(INSERT_PRODUCT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
			preparedStatement.setInt(1, Product.getQuantity());
			preparedStatement.setInt(2, Product.getPrice());
			preparedStatement.setFloat(3, Product.getAvarage_rating());
			preparedStatement.setString(4, Product.getProduct_description());
			preparedStatement.setString(5, Product.getBook_title());
			preparedStatement.setString(6, Product.getPublisher());
			preparedStatement.setDate(7, Product.getPublish_date());
			preparedStatement.setInt(8, Product.getID_Author());
			preparedStatement.setInt(9, Product.getID_Category());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Product selectProduct(int ID_Product) {
		Product Product = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) 
		{
			preparedStatement.setInt(1, ID_Product);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				float avarage_rating = rs.getFloat("avarage_rating");
				String product_description = rs.getString("product_description");
				String book_title = rs.getString("book_title");
				String publisher = rs.getString("publisher");
				Date publish_date = rs.getDate("publish_date");
				int iD_Author = rs.getInt("ID_Author");
				int iD_Category = rs.getInt("ID_Category");			
				Product = new Product(ID_Product, quantity, price, avarage_rating,
						product_description, book_title, publisher, publish_date,
						iD_Author,iD_Category);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Product;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public boolean deleteProduct(int ID_Product) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
			statement.setInt(1, ID_Product);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public List<Product> selectAllProduct() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Product> Products = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ID_Product = rs.getInt("ID_Product");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				float avarage_rating = rs.getFloat("avarage_rating");
				String product_description = rs.getString("Product_description");
				String book_title = rs.getString("Book_title");
				String publisher = rs.getString("Publisher");
				Date publish_date = rs.getDate("publish_date");
				int iD_Author = rs.getInt("ID_Author");
				int iD_Category = rs.getInt("ID_Category");
				Products.add(new Product(ID_Product, quantity, price, avarage_rating,
						product_description, book_title, publisher, publish_date,
						iD_Author,iD_Category));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Products;
	}
	
	public List<Product> selectAllProductbyCategory(String ID_Category) 
	{
		List<Product> Products = new ArrayList<>();
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_Category);) 
		{
			preparedStatement.setString(1, ID_Category);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ID_Product = rs.getInt("ID_Product");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("price");
				float avarage_rating = rs.getFloat("avarage_rating");
				String product_description = rs.getString("product_description");
				String book_title = rs.getString("book_title");
				String publisher = rs.getString("publisher");
				Date publish_date = rs.getDate("publish_date");
				int iD_Author = rs.getInt("ID_Author");
				int iD_Category = rs.getInt("ID_Category");
				Products.add(new Product(ID_Product, quantity, price, avarage_rating,
						product_description, book_title, publisher, publish_date,
						iD_Author,iD_Category));
			}
		} catch (SQLException e) {
			printSQLException(e);}
		return Products;
	}
	
	public boolean updateProduct(Product Product) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
			System.out.println("updated Product:"+ preparedStatement);
			preparedStatement.setInt(1, Product.getQuantity());
			preparedStatement.setInt(2, Product.getPrice());
			preparedStatement.setFloat(3, Product.getAvarage_rating());
			preparedStatement.setString(4, Product.getProduct_description());
			preparedStatement.setString(5, Product.getBook_title());
			preparedStatement.setString(6, Product.getPublisher());
			preparedStatement.setDate(7, Product.getPublish_date());
			preparedStatement.setInt(8, Product.getID_Author());
			preparedStatement.setInt(9, Product.getID_Category());
			preparedStatement.setInt(10, Product.getID_Product());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public Category selectCategory(int ID_Category) {
		Category Category = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);) 
		{
			preparedStatement.setInt(1, ID_Category);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String categoryname = rs.getString("category_name");
				String description = rs.getString("description");		
				Category = new Category(ID_Category,categoryname, description);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Category;
	}
	
	public List<Category> selectAllCategory() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Category> Categorys = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ID_Category = rs.getInt("ID_Category");
				String categoryname = rs.getString("category_name");
				String description = rs.getString("description");		
				Categorys.add(new Category(ID_Category,categoryname, description));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Categorys;
	}
	
	public List<String> getcategoryname(List<Category> Categorys)
	{
		List<String> catename = new ArrayList<>();
		for(Category category : Categorys)
		{
			catename.add(category.getCategory_name());
		}
		return catename;
	}
	public int getIDbyNameCategory(String categoryname, List<Category> Categorys)
	{
		int ID_Category = -1;
		for(Category category : Categorys)
		{
			if(categoryname.toLowerCase().equals(category.getCategory_name().toLowerCase()))
			{
				ID_Category = category.getID_Category();
				break;
			}
		}
		return ID_Category;
	}
	
	public String getNamebyIDCategory(int ID_Category, List<Category> Categorys)
	{
		String Categoryname = "";
		for(Category Category : Categorys)
		{
			if(ID_Category == Category.getID_Category())
			{
				Categoryname = Category.getCategory_name();
				break;
			}
		}
		return Categoryname;
	}
	
	public Author selectAuthor(int ID_Author) {
		Author Author = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AUTHOR_BY_ID);) 
		{
			preparedStatement.setInt(1, ID_Author);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String Authorname = rs.getString("authorname");
				Date dateofbirth = rs.getDate("dateofbirth");
				String description = rs.getString("description");
				Author = new Author(ID_Author,Authorname,dateofbirth, description);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Author;
	}
	
	public List<Author> selectAllAuthor() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Author> Authors = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHOR);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int ID_Author = rs.getInt("ID_Author");
				String Authorname = rs.getString("authorname");
				Date dateofbirth = rs.getDate("dateofbirth");
				String description = rs.getString("description");		
				Authors.add(new Author(ID_Author,Authorname,dateofbirth, description));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Authors;
	}
	
	public List<String> getauthorname(List<Author> Authors)
	{
		List<String> catename = new ArrayList<>();
		for(Author Author : Authors)
		{
			catename.add(Author.getAuthorname());
		}
		return catename;
	}
	public int getIDbyNameAuthor(String authorname, List<Author> Authors)
	{
		int ID_Author = -1;
		for(Author author : Authors)
		{
			if(authorname.toLowerCase().equals(author.getAuthorname().toLowerCase()))
			{
				ID_Author = author.getID_Author();
				
				break;
			}
		}
		return ID_Author;
	}
	
	public String getNamebyIDAuthor(int ID_Author, List<Author> Authors)
	{
		String authorname = "";
		for(Author Author : Authors)
		{
			if(ID_Author == Author.getID_Author())
			{
				authorname = Author.getAuthorname();
				break;
			}
		}
		return authorname;
	}
	
	public ProductShow convertProduct(Product Product)
	{
		String authorname = getNamebyIDAuthor(Product.getID_Author(),selectAllAuthor());
		String Categoryname = getNamebyIDCategory(Product.getID_Category(),selectAllCategory());
		
		ProductShow ps = new ProductShow(Product.getID_Product(),Product.getQuantity(),Product.getPrice()
										,Product.getAvarage_rating(),Product.getProduct_description()
										,Product.getBook_title(),Product.getPublisher(),Product.getPublish_date()
										,authorname,Categoryname);
		return ps;
	}
	public List<ProductShow> convertProduct(List<Product> Products)
	{
		List<ProductShow> ProductShows = new ArrayList<>();
		for(Product product : Products)
		{
			ProductShows.add(convertProduct(product));
		}
		return ProductShows;
	}
	
	public Product convertProductShow(ProductShow ProductShow)
	{
		int ID_Author = getIDbyNameAuthor(ProductShow.getAuthorname(),selectAllAuthor());
		int ID_Category = getIDbyNameCategory(ProductShow.getCategory_name(),selectAllCategory());
		
		Product p = new Product(ProductShow.getID_Product(),ProductShow.getQuantity(),ProductShow.getPrice()
				,ProductShow.getAvarage_rating(),ProductShow.getProduct_description()
				,ProductShow.getBook_title(),ProductShow.getPublisher(),ProductShow.getPublish_date()
				,ID_Author,ID_Category);
		return p;
	}
	
	public List<Product> convertProductShow(List<ProductShow> ProductShows)
	{
		List<Product> Products = new ArrayList<>();
		for(ProductShow productshow : ProductShows)
		{
			Products.add(convertProductShow(productshow));
		}
		return Products;
	}
	
	public void insertAuthorbyName(String authorname)
	{
		int check = 0;
		for(Author author : selectAllAuthor())
		{
			if(authorname.toLowerCase() == author.getAuthorname().toLowerCase())
			{
				check = 1;
				break;
			}
		}
		if(check == 0)
		{
			String description = "No description yet";
			Date dateofbirth = Date.valueOf("2000-01-01");
			System.out.print(INSERT_AUTHOR_SQL);
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR_SQL)) {
				preparedStatement.setString(1,authorname);
				preparedStatement.setDate(2, dateofbirth);
				preparedStatement.setString(3, description);
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
	}
	
	public List<Rating> selectRatingByIDProduct(int ID_Product)
	{
		List<Rating> ratings = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RATING_BY_ID_PRODUCT);)
		{
			preparedStatement.setInt(1, ID_Product);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				int ID_Rating = rs.getInt("ID_Rating");
				int ID_Customer = rs.getInt("ID_Customer");
				int rating_star = rs.getInt("rating_star");
				String review_text = rs.getString("review_text");
				
				ratings.add(new Rating(ID_Rating, ID_Customer,ID_Product,rating_star,review_text));
			}
		}
		catch (SQLException e) 
		{
			printSQLException(e);
		}
		return ratings;
	}
	
	public void updateavarage_rating(int ID_Product)
	{
		Product p = selectProduct(ID_Product);
		List<Rating> ratings = selectRatingByIDProduct(ID_Product);
		int Totalrating = 0;
		for(Rating rating : ratings)
		{
			Totalrating += rating.getRating_star();
		}
		float avarage_rating = (float) Totalrating/ratings.size();
		p.setAvarage_rating(avarage_rating);
		try 
		{
		updateProduct(p);
		}
		catch (SQLException e) 
		{
			printSQLException(e);
		}
	}
	
	public List<ProductShow> GetPSListByCategory(String categorys[])
	{
		List<ProductShow> pss = new ArrayList<>();
		for(String s: categorys)
		{
			if (s.equals("All"))
			{
				pss = convertProduct(selectAllProduct());
				return pss;
			}
		}
		
		for(ProductShow ps : convertProduct(selectAllProduct()))
			{
				for(String s : categorys)
				{
					if(s.equals(ps.getCategory_name()))
					{
						pss.add(ps);
						break;
					}
				}
			}
		return pss;
	}
	public List<ProductShow> GetPSListByName(String name)
	{
		List<ProductShow> pss = new ArrayList<>();
		for(ProductShow ps : convertProduct(selectAllProduct()))
		{
			if(ps.getBook_title().contains(name))
			{
				pss.add(ps);
			}
		}
		return pss;
	}
	
	public List<ProductShow> GetPSListByPrice(String price[])
	{
		List<ProductShow> pss = new ArrayList<>();
		for(String s : price)
		{
			if(s.equals("0"))
			{
				pss = convertProduct(selectAllProduct());
				break;
			}
			switch (s) {
			case "1":
			{
				for (ProductShow ps : convertProduct(selectAllProduct()))
				{
					if(ps.getPrice()< 100000) pss.add(ps);
				}
				break;
			}
			case "2":
				for (ProductShow ps : convertProduct(selectAllProduct()))
				{
					if(ps.getPrice()>100000 && ps.getPrice()<500000) pss.add(ps);
					
				}
				break;
			case "3":
				for (ProductShow ps : convertProduct(selectAllProduct()))
				{
					if(ps.getPrice()>500000 && ps.getPrice()<1000000) pss.add(ps);
					
				}
				break;
			case "4":
				for (ProductShow ps : convertProduct(selectAllProduct()))
				{
					if(ps.getPrice()>1000000) pss.add(ps);
					
				}
				break;
			//default:
				//pss = convertProduct(selectAllProduct());
				//break;
			}
		}
		
		return pss;
	}
	
	public void insertRating(Rating Rating)
	{
		System.out.println(INSERT_RATING_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RATING_SQL)) 
		{
			preparedStatement.setInt(1, Rating.getID_Customer());
			preparedStatement.setInt(2, Rating.getID_Product());
			preparedStatement.setInt(3, Rating.getRating_star());
			preparedStatement.setString(4, Rating.getReview_text());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<ProductShow> GetBookwithsameCategory(ProductShow productShow)
	{
		List<ProductShow> pss = new ArrayList<>();
		List<ProductShow> listps = convertProduct(selectAllProduct());
		for(ProductShow ps : listps)
		{
			if (ps.getCategory_name().equals(productShow.getCategory_name()))
			{
				pss.add(ps);
			}
		}
		
		return pss;
	}
	
	public List<ProductShow> GetBookwithsameAuthor(ProductShow productShow)
	{
		List<ProductShow> pss = new ArrayList<>();
		List<ProductShow> listps = convertProduct(selectAllProduct());
		for(ProductShow ps : listps)
		{
			if (ps.getAuthorname().equals(productShow.getAuthorname()))
			{
				pss.add(ps);
			}
		}
		
		return pss;
	}
}
