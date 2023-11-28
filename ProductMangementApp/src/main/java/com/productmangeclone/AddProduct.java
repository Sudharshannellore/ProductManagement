package com.productmangeclone;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Integer productid = Integer.parseInt(request.getParameter("productid"))    ;
	        String productName = request.getParameter("productname");
	        Double productPrice = Double.parseDouble(request.getParameter("price"));
	        String productmadein = request.getParameter("madein");
	        String productCompany = request.getParameter("brand");
	        Date productmanufacturedate = Date.valueOf(request.getParameter("manfacturedate"));
	       Date productexpiredate = Date.valueOf(request.getParameter("expirydate"));
	        
	        
	        // get image data from request       
	        Part productimag=request.getPart("productimage");
	        InputStream productimage =productimag.getInputStream();

	    
	        //sending data to dao layer
	        ProductDAO dao = new ProductDAO();
			
			
			//adding data into productinfo object
			productinfo productinfo=new productinfo();
				
			
			productinfo.setProductid(productid);
			productinfo.setProductName(productName);
			productinfo.setProductPrice(productPrice);
			productinfo.setProductmadein(productmadein);
			productinfo.setProductCompany(productCompany);
			productinfo.setProductmanufacturedate(productmanufacturedate);
			productinfo.setProductexpiredate(productexpiredate);
			productinfo.setProductimage(productimage);
					
			//sending data into saveproductmethod
		int result=	dao.saveproduct(productinfo);
				
		//set the result value into request object
			request.setAttribute("result",result);
			
			//forwarding the response to jsp
			RequestDispatcher dispatcher=request.getRequestDispatcher("addproductstatus.jsp");
			dispatcher.forward(request, response);

		
	}

}
