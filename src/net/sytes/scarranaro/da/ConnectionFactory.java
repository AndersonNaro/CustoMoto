package net.sytes.scarranaro.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public static java.sql.Connection getConnection()  {  
    	Connection connection = null; 

	       
    	try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
			connection = 
					 DriverManager.getConnection("jdbc:mysql://localhost:3306/scandb","root","root");
			return connection;  
			
    	} catch (ClassNotFoundException e) {              
    		System.out.println("O driver expecificado nao foi encontrado.");  
    		return null;  
    		
    	} catch (SQLException e) {  
    		System.out.println("Nao foi possivel conectar ao banco de dados.");  
    		return null;  
    	}  
				
	}      
	    
	
}
