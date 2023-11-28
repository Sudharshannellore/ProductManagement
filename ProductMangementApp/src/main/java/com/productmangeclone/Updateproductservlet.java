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
 * Servlet implementation class Updateproductservlet
 */
@WebServlet("/Updateproductservlet")
@MultipartConfig
public class Updateproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get product details from the request
        Integer productid = Integer.parseInt(request.getParameter("productid"))    ;
        String productName = request.getParameter("productname");
        double productPrice = Double.parseDouble(request.getParameter("price"));
        String productmadein = request.getParameter("madein");
        String productCompany = request.getParameter("brand");
        Date productmanufacturedate = Date.valueOf(request.getParameter("manfacturedate"));
       Date productexpiredate = Date.valueOf(request.getParameter("expirydate"));
        
        
        // get image data from request       
    
        //sending data to dao laye
		
		
		//adding data into productinfo object
		productinfo productupdate=new productinfo();
			
		
		productupdate.setProductid(productid);
		productupdate.setProductName(productName);
		productupdate.setProductPrice(productPrice);
		productupdate.setProductmadein(productmadein);
		productupdate.setProductCompany(productCompany);
		productupdate.setProductmanufacturedate(productmanufacturedate);
		productupdate.setProductexpiredate(productexpiredate);
		
		
		 ProductDAO dao = new ProductDAO();
			
		    
	     Part newImagePart = request.getPart("productimage");
	     if (newImagePart != null && newImagePart.getSize() > 0) {
	            productupdate.setProductimage(newImagePart.getInputStream());
	        } else {
	        	 productinfo existingProduct = dao.getproductid(productid);
	 
	            productupdate.setProductimage(existingProduct.getProductimage());;
	        }
	        
		
		
				
		//sending data into updateproduct method
	      int updateresult=dao.updateproduct(productupdate);
	
		//forwarding the response to jsp
		
		if(updateresult==1)
		{
		RequestDispatcher dispatcher=request.getRequestDispatcher("allproducts.jsp");
		dispatcher.forward(request, response);
		
		}
		

	}

}
