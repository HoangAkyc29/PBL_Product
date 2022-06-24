package com.xadmin.productmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
//import java.sql.SQLException;
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
 * Servlet implementation class Productdetail
 */
@WebServlet("/Productdetail")
public class Productdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productdetail() 
    {
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
		int ID = 0;
		ID = Integer.parseInt(request.getParameter("ID_Product"));
		String action = request.getParameter("action");
		if(action == null) action = "";
		ProductShow ps = null;
			ps = productDAO.convertProduct(productDAO.selectProduct(ID));
			if(ps == null) System.out.print("aaaaaaaa"); else System.out.print("bbbbbb");
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
				searchname(request,response);
				break;
			}
			default:
				Product_detail(request, response, ps);
				break;
			}
		} catch (Exception ex) 
		{
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void searchname(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
			{
		String name = request.getParameter("namesearch");
		System.out.print(name);
		List<ProductShow> listProductShow = productDAO.GetPSListByName(name);
		request.setAttribute("listProductShow", listProductShow);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-list.jsp");
		dispatcher.forward(request, response);
			}
	protected void Product_detail(HttpServletRequest request, HttpServletResponse response, ProductShow ps) throws ServletException, IOException
	{
		List<ProductShow> listProductShow = productDAO.convertProduct(productDAO.selectAllProduct());
		List<ProductShow> listPSsameCategory = productDAO.GetBookwithsameCategory(ps);
		List<ProductShow> listPSsameAuthor = productDAO.GetBookwithsameAuthor(ps);
		request.setAttribute("listPSsameCategory" , listPSsameCategory);
		request.setAttribute("listPSsameAuthor" , listPSsameAuthor);
		request.setAttribute("listProductShow", listProductShow);
		request.setAttribute("ProductShowdetail", ps);
		List<Category> categorys = productDAO.selectAllCategory();
		request.setAttribute("categorys", categorys);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Product-form.jsp");
		dispatcher.forward(request, response);
	}
}
