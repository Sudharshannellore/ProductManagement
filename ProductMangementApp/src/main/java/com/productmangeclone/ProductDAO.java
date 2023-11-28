package com.productmangeclone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public int saveproduct(productinfo productinfo)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int saveresult=0;

	 try {
		 	connection=DataBaseUtils.create();
			preparedStatement=connection.prepareStatement("insert into productdetails values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1,productinfo.getProductid());
			preparedStatement.setString(2,productinfo.getProductName());
			preparedStatement.setDouble(3,productinfo.getProductPrice());
			preparedStatement.setString(4,productinfo.getProductmadein());
			preparedStatement.setString(5,productinfo.getProductCompany());
			preparedStatement.setDate(6,productinfo.getProductmanufacturedate());
			preparedStatement.setDate(7,productinfo.getProductexpiredate());
			preparedStatement.setBinaryStream(8,productinfo.getProductimage());

			saveresult=preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	 
		}
	 
	 
	return saveresult;
	}

	public static List<productinfo> allproducts(){
		Connection connection=null;
		PreparedStatement statement = null;
		
		List<productinfo>userdata=new ArrayList<productinfo>();
		
		try {
			connection=DataBaseUtils.create();
			 statement=connection.prepareStatement("select * from productdetails");
			
			//Retrieving and storing data into resultset object
			ResultSet resultSet=statement.executeQuery();
			
			
			while (resultSet.next()) {
			
					//storing the resultset object into info object
			  		productinfo info=new productinfo();
			  
			  info.setProductid(resultSet.getInt(1));
			  info.setProductName(resultSet.getString(2));
			  info.setProductPrice(resultSet.getDouble(3));
			  info.setProductmadein(resultSet.getString(4));
			  info.setProductCompany(resultSet.getString(5));
			  info.setProductmanufacturedate(resultSet.getDate(6));
			  info.setProductexpiredate(resultSet.getDate(7));			  
			  info.setProductimage(resultSet.getBinaryStream(8));
			  
			  userdata.add(info);
		  }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return userdata;
	}
	public int deleteproduct(Integer productid) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int deleteresult=0;
		
		try {
			connection=DataBaseUtils.create();
			preparedStatement=connection.prepareStatement("delete from productdetails where productid=?");
			preparedStatement.setInt(1, productid);
		deleteresult=	preparedStatement.executeUpdate();
		} catch (Exception e) {
		}
		
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteresult;			
	}	
	
	public int updateproduct(productinfo productupdate) {
		
		
		
		Connection connection=null;
		PreparedStatement preparedStatement1=null;
		int updateresult=0;
		

		try {
		    connection = DataBaseUtils.create();
		    preparedStatement1 = connection.prepareStatement("update productdetails set productName=?, productPrice=?, productmadein=?, productCompany=?, productmanufacturedate=?, productexpiredate=?, productimage=? where productid=?");

		    
		    preparedStatement1.setString(1, productupdate.getProductName());
		    preparedStatement1.setDouble(2, productupdate.getProductPrice());
		    preparedStatement1.setString(3, productupdate.getProductmadein());
		    preparedStatement1.setString(4, productupdate.getProductCompany());
		    preparedStatement1.setDate(5, productupdate.getProductmanufacturedate());
		    preparedStatement1.setDate(6, productupdate.getProductexpiredate());
		    preparedStatement1.setBinaryStream(7, productupdate.getProductimage());
		    preparedStatement1.setInt(8, productupdate.getProductid());
		    updateresult = preparedStatement1.executeUpdate();

		} catch (Exception e) {
		    // TODO: handle exception
		} finally {
		    // Close resources in a finally block to ensure closure
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    if (preparedStatement1 != null) {
		        try {
		            preparedStatement1.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return updateresult;
		
	}
	
	//edit
	public productinfo getproductid(int productid) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;	
		productinfo existingproduct=null;
		
		try {
			connection = DataBaseUtils.create();
			preparedStatement=connection.prepareStatement("select * from productdetails where productid=?");

			preparedStatement.setInt(1, productid);
		ResultSet resultSet	=preparedStatement.executeQuery();
		if (resultSet.next()) {
				
				//storing the resultset object into info object
		  		 existingproduct=new productinfo();
		  
		  		existingproduct.setProductid(resultSet.getInt(1));
		  		existingproduct.setProductName(resultSet.getString(2));
		  		existingproduct.setProductPrice(resultSet.getDouble(3));
		  		existingproduct.setProductmadein(resultSet.getString(4));
		  		existingproduct.setProductCompany(resultSet.getString(5));
		  		existingproduct.setProductmanufacturedate(resultSet.getDate(6));
		  		existingproduct.setProductexpiredate(resultSet.getDate(7));			  
		  		existingproduct.setProductimage(resultSet.getBinaryStream(8));
		  
			
		}
			
		} catch (Exception e) {
		} 
		return existingproduct;
	
	}	
	
}

