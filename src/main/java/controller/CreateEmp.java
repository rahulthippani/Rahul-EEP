package controller;



import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Emp;


public class CreateEmp {

	public String execute(Emp ep) {
  
		try {
			Connection connection = Connectionprovider.getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO emp(name, pos) VALUES(?,?) Returning id");
			stmt.setString(1, ep.getName());
			stmt.setString(2, ep.getPosition());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				return rs.getString("id");
				
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}
	
	public static void main(String args[])
	{
		CreateEmp demo=new CreateEmp();
		
		Emp a = new Emp();
		a.setName("Vibbs");
		a.setPosition("CEO");
		
		System.out.println(demo.execute(a));
	}
	
	
}
