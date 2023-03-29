package dao;
import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Data.Kysymys;

import Data.Admin;
import Data.Ehdokkaat;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao() {
		url = "jdbc:mysql://localhost:3306/vaalikone";
		user = "haltia";
		pass ="1234";
	}
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Kysymys>lueKysymykset(){
		ArrayList<Kysymys> list= new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from kysymykset");
			while(rs.next()){
				Kysymys k = new Kysymys();
				k.setKysymys(rs.getString("kysymys"));
				list.add(k);
			}
			return list;
		}catch(SQLException e) {
			return null;
		}
	}

	public ArrayList<Integer> lueVastaukset(int id){
		ArrayList<Integer> list= new ArrayList<>();
		try {
			String sql="select * from vastaukset where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				list.add(RS.getInt("vastaus"));
			}
			return list;
		}catch(SQLException e) {
			return null;
		}
	}
	
	public Admin AdminLogin(String username, String passwrd){
		Admin admin = null;
		try {
			
			PreparedStatement pstmt= conn.prepareStatement("select * from adminlogin where username=? and passwrd=?");
			pstmt.setString(1, username);
			pstmt.setString(2, passwrd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				admin= new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPasswrd(rs.getString("passwrd"));
			}
			return admin;
			
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public ArrayList<Ehdokkaat>lueEhdokkaat(){
		ArrayList<Ehdokkaat> edhokkaatlist= new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ehdokkaat");
			while(rs.next()){
				Ehdokkaat ed = new Ehdokkaat();
				ed.setEhdokas_id(rs.getInt("ehdokas_id"));
				ed.setSukunimi(rs.getString("sukunimi"));
				ed.setEtunimi(rs.getString("etunimi"));
				ed.setPuolue(rs.getString("puolue"));
				ed.setEduskunta(rs.getString("MIKSI_EDUSKUNTAAN"));
				ed.setEdistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				
				
				
				edhokkaatlist.add(ed);
			}
			return edhokkaatlist;
		}catch(SQLException e) {
			return null;
		}
	}
public Ehdokkaat lueEhdokas(String ehdokas_id) {
		
		Ehdokkaat ed = null;
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("select * from ehdokkaat where ehdokas_id=?");
			pstmt.setString(1, ehdokas_id);
			
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()){
				ed=new Ehdokkaat();
				
				ed.setEhdokas_id(rs.getInt("ehdokas_id"));
				ed.setSukunimi(rs.getString("sukunimi"));
				ed.setEtunimi(rs.getString("etunimi"));
				ed.setPuolue(rs.getString("puolue"));
				ed.setEduskunta(rs.getString("MIKSI_EDUSKUNTAAN"));
				ed.setEdistaa(rs.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				
			}
			return ed;
		}
		catch(SQLException e) {
			return null;
		}
		
	}
	
	
	public ArrayList<Ehdokkaat> Muokkaehdokas(Ehdokkaat ed){
		try {
			PreparedStatement pstmt = conn.prepareStatement("update ehdokkaat set sukunimi=?, etunimi=?, puolue=?, MIKSI_EDUSKUNTAAN=?, MITA_ASIOITA_HALUAT_EDISTAA=? where ehdokas_id=?");
			
			pstmt.setString(1, ed.getSukunimi());
			pstmt.setString(2, ed.getEtunimi());
			pstmt.setString(3, ed.getPuolue());	
			pstmt.setString(4, ed.getEduskunta());
			pstmt.setString(5, ed.getEdistaa());
			pstmt.setInt(6, ed.getEhdokas_id());
			pstmt.executeUpdate();
			return lueEhdokkaat();

		}
		catch(SQLException e) {
			return null;
		}
	}

	public int countEhdokkaat() {
		int maara = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(DISTINCT ehdokas_id) AS ehdokkaat FROM vastaukset");
			while (rs.next()) {
				maara = rs.getInt("ehdokkaat");
			}
			return maara;
	}catch(SQLException e) {
		return 0;
	}
}
		
	
	
	
	
	
	
	
	

}
