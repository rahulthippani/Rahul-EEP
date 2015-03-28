package controller;



import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Emp;



public class ListEmp {

	public ArrayList<Emp> execute() {
		ArrayList<Emp> ret = new ArrayList<Emp>();
		try {
			Connection connection = Connectionprovider.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM empp");
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setPosition(rs.getString("pos"));
				ret.add(e);
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String args[])
	{
		
		
		ListEmp list=new ListEmp();
		ArrayList<Emp> demo = list.execute();
		
		for(Emp li : demo){
			System.out.println(li.getName());
			System.out.println(li.getPosition());
		
		}
		
	}
}