package com.xadmin.productmanagement.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.productmanagement.dao.*;
import com.xadmin.productmanagement.bean.*;

/**
 * Servlet implementation class ProductQL
 */
@WebServlet("/ProductQL")
public class ProductQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductQL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		productDAO = new ProductDAO();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action == null) action = "";
		try {
			switch (action) {
			case "insert":
				insertProduct(request, response);
				break;
			case "delete":
				deleteProduct(request, response);
				break;
			case "update":
				updateProduct(request, response);
				break;
			case "searchprice":
			{
				//searchprice(request,response);
				break;
			}
			case "searchbook":
			{
				//searchbook(request,response);
				break;
			}
			case "searchname":
			{
				//searchname(request,response);
				break;
			}
			default:
				listProduct(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ProductShow> listProductShow = productDAO.convertProduct(productDAO.selectAllProduct());
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductQL.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("Product-list.jsp");
	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int ID_Product = Integer.parseInt(request.getParameter("ID_Product"));
		productDAO.deleteProduct(ID_Product);
		response.sendRedirect("ProductQL");
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		float avarage_rating = 0;
		String Product_description = request.getParameter("Product_description");
		String book_title = request.getParameter("Book_title");
		String publisher = request.getParameter("publisher");
		Date publish_date = Date.valueOf(request.getParameter("publish_date"));
		String authorname = request.getParameter("authorname");
		String category_name = request.getParameter("category_name");
		
		productDAO.insertAuthorbyName(authorname);
		ProductShow ps = new ProductShow(quantity,price,avarage_rating,
			Product_description, book_title, publisher, publish_date, authorname, category_name);
		Product p = productDAO.convertProductShow(ps);
		productDAO.insertProduct(p);
		response.sendRedirect("ProductQL");
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException 
	{
		int ID_Product = Integer.parseInt(request.getParameter("ID_Product2"));
		int quantity = Integer.parseInt(request.getParameter("quantity2"));
		int price = Integer.parseInt(request.getParameter("price2"));
		float avarage_rating = Float.parseFloat(request.getParameter("avarage_rating2"));
		String Product_description = request.getParameter("Product_description2");
		String book_title = request.getParameter("Book_title2");
		String publisher = request.getParameter("publisher2");
		Date publish_date = Date.valueOf(request.getParameter("publish_date2"));
		String authorname = request.getParameter("authorname2");
		String category_name = request.getParameter("category_name2");
		productDAO.insertAuthorbyName(authorname);
		ProductShow ps = new ProductShow(ID_Product,quantity,price,avarage_rating,
			Product_description, book_title, publisher, publish_date, authorname, category_name);
		Product p = productDAO.convertProductShow(ps);
		productDAO.updateProduct(p);
		response.sendRedirect("ProductQL");
	}
}
