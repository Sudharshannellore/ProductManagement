package com.productmangeclone;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Editproductservlet
 */
@WebServlet("/Editproductservlet")
public class Editproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		int productid= Integer.parseInt(request.getParameter("productid"));   
		 
		ProductDAO dao= new ProductDAO();
		productinfo existingproduct =dao.getproductid(productid);
		
		request.setAttribute("existingproduct", existingproduct);
		
		
		if(existingproduct!=null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/EditProduct.jsp");
			dispatcher.forward(request, response);
			
			
			
		}
	}
		
		
	}

