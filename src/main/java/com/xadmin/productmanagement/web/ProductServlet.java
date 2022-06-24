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
 * Servlet implementation class ProductServlet
 */
@WebServlet( urlPatterns = "/displayproduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		productDAO = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if(action == null) action = "";
		try {
			switch (action) {
			case "new":
				//showNewForm(request, response);
				break;
			case "insert":
				//insertProduct(request, response);
				break;
			case "delete":
				//deleteProduct(request, response);
				break;
			case "edit":
				//showEditForm(request, response);
				break;
			case "update":
				//updateProduct(request, response);
				break;
			case "searchprice":
			{
				searchprice(request,response);
				break;
			}
			case "searchbook":
			{
				searchbook(request,response);
				break;
			}
			case "searchname":
			{
				searchname(request,response);
				break;
			}
			default:
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void searchname(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("namesearch");
		System.out.print(name);
		//request.setAttribute("reloadmess", name);
		List<ProductShow> listProductShow = productDAO.GetPSListByName(name);
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-list.jsp");
		dispatcher.forward(request, response);
	}
	private void searchbook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String category[] = request.getParameterValues("categorysearch");
		List<ProductShow> listProductShow = productDAO.GetPSListByCategory(category);	
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-list.jsp");
		dispatcher.forward(request, response);
	}
	private void searchprice(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String price[] = request.getParameterValues("pricesearch");
		for(String s: price)
		{
			System.out.println(s);
		}
		List<ProductShow> listProductShow = productDAO.GetPSListByPrice(price);
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-list.jsp");
		dispatcher.forward(request, response);
	}
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ProductShow> listProductShow = productDAO.convertProduct(productDAO.selectAllProduct());
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-list.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("Product-list.jsp");
	}
}
