package com.faizan.jerseyrestfull;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlianRepository {

	List<Alian> alians;

	private static String username = "root";
	private static String url = "jdbc:mysql://localhost:3306/student";
	private static String pass = "admin";
	Connection con=null;
	public AlianRepository() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error:" +e);
		}
		

	}

	public List<Alian> getAlian() {
		alians=new ArrayList<>();
		String querry="Select * from std_detail";
		try {
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(querry);
			while(res.next()) {
				Alian a=new Alian();
				a.setId(res.getInt(1));
				a.setName(res.getString(2));
				a.setPoint(res.getInt(3));
				alians.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR:"+e);
		}
		
		return alians;
	}

	public Alian getonealian(int id) {
		String querry="Select * from std_detail where id="+id;
		Alian a=new Alian();
		try {
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(querry);
			if(res.next()) {
				
				a.setId(res.getInt(1));
				a.setName(res.getString(2));
				a.setPoint(res.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR:"+e);
		}
		
		return a;
		}

	public void create(Alian a) {
		// TODO Auto-generated method stub
		String querry="insert into std_detail values (?,?,?)" ;
		try {
			PreparedStatement st=con.prepareStatement(querry);
			st.setInt(1,a.getId());
			st.setString(2,a.getName());
			st.setInt(3, a.getPoint());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} 	
		
		
	}
	public void update(Alian a) {
		// TODO Auto-generated method stub
		String querry="update  std_detail set Name=?,point=? where id=?" ;
		try {
			PreparedStatement st=con.prepareStatement(querry);
			System.out.println(a.getName());
			st.setString(1,a.getName());
			st.setInt(2, a.getPoint());
			st.setInt(3,a.getId());
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} 	
		
		
	}

//	public void delete(Alian a) {
//		// TODO Auto-generated method stub
//		
//	}
}
