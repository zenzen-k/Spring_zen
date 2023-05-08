package com.spring.ex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.DTO.PDto;

public class PDao {
	
	private static PDao pdao = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	private PDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static PDao getInstance() {
		if(pdao == null) {
			pdao = new PDao();
		}
		return pdao;
	}
	
	public void write(String id, String name, int age) {
		String sql = "insert into person values(pseq.nextval, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			int cnt = ps.executeUpdate();
			System.out.println("insert °á°ú : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<PDto> getAllPerson() {
		ArrayList<PDto> plist = new ArrayList<PDto>();
		String sql = "select * from person order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PDto pd = new PDto();
				pd.setNum(rs.getInt("num"));
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
				plist.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return plist;
	}

	public PDto getPersonByNum(String num) {
		System.out.println("DAO num : " + num);
		PDto pd = new PDto();
		String sql = "select * from person where num=" + num;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				pd.setNum(rs.getInt("num"));
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pd;
	}

	public void updatePerson(HttpServletRequest request) {
		String sql = "update person set id=?, name=?, age=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, request.getParameter("id"));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("age"));
			ps.setString(4, request.getParameter("num"));
			int cnt = ps.executeUpdate();
			System.out.println("update cnt : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deletePerson(String num) {
		String sql = "delete person where num=" + num;
		try {
			ps = conn.prepareStatement(sql);
			int cnt = ps.executeUpdate();
			System.out.println("delete cnt : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
