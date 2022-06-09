package com.whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.whatsapp.entity.WhatsappUser;

public class WhatsappDAO implements WhatsappDAOInterface {

	public int createProfileDAO(WhatsappUser wu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kgcollege","root","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, wu.getName());
			ps.setString(2, wu.getPassword());
			ps.setString(3, wu.getEmail());
			ps.setString(4, wu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean loginProfileDAO(WhatsappUser wu) {
		boolean b=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kgcollege","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=? and password=?");
			ps.setString(1, wu.getEmail());
			ps.setString(2, wu.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				b=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public WhatsappUser viewProfileDAO(WhatsappUser wu) {
		WhatsappUser w=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kgcollege","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser where email=?");
			ps.setString(1, wu.getEmail());
						
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				w=new WhatsappUser();
				w.setName(n);
				w.setPassword(p);
				w.setEmail(e);
				w.setAddress(a);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return w;
	}

	public int deleteProfileDAO(WhatsappUser wu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kgcollege","root","rajesh");
			PreparedStatement ps=con.prepareStatement("delete from whatsappuser where email=?");
			
			ps.setString(1, wu.getEmail());
			
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<WhatsappUser> viewAllProfileDAO() {
		List<WhatsappUser> w1=new ArrayList<WhatsappUser>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kgcollege","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from whatsappuser");
									
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				WhatsappUser w=new WhatsappUser();
				w.setName(n);
				w.setPassword(p);
				w.setEmail(e);
				w.setAddress(a);
				
				w1.add(w);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return w1;
	}

}













