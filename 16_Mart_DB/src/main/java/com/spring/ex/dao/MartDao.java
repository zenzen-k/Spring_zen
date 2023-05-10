package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.MartDto;

public class MartDao {
	private static MartDao mdao;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "jspid";
	String dbpw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private MartDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MartDao getInstance() {
		if(mdao == null) {
			mdao = new MartDao();
		}
		return mdao;
	}

	public void insertProduct(MartDto mdto) {
		String sql = "insert into emart values(e_seq.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			ps.setString(3, mdto.getProduct());
			ps.setString(4, mdto.getTime());
			ps.setString(5, mdto.getApprove());
			ps.setString(6, mdto.getAgree());
			int cnt = ps.executeUpdate();
			System.out.println("insert cnt : " + cnt);
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

	public ArrayList<MartDto> getAllMart() {
		ArrayList<MartDto> lists = new ArrayList<MartDto>();
		String sql = "select * from emart order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MartDto mdto = new MartDto();
				mdto.setNum(rs.getInt("num"));
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setProduct(rs.getString("product"));
				mdto.setTime(rs.getString("time"));
				mdto.setApprove(rs.getString("approve"));
				mdto.setAgree(rs.getString("agree"));
				lists.add(mdto);
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
		return lists;
	}

	public MartDto getMartByNum(String num) {
		MartDto mdto = new MartDto();
		String sql = "select * from emart where num=" + num;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				mdto.setNum(rs.getInt("num"));
				mdto.setId(rs.getString("id"));
				mdto.setPw(rs.getString("pw"));
				mdto.setProduct(rs.getString("product"));
				mdto.setTime(rs.getString("time"));
				mdto.setApprove(rs.getString("approve"));
				mdto.setAgree(rs.getString("agree"));
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
		return mdto;
	}

	public void updateMart(MartDto mdto) {
		String sql = "update emart set id=?, pw=?, product=?, time=?, approve=?, agree=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mdto.getId());
			ps.setString(2, mdto.getPw());
			ps.setString(3, mdto.getProduct());
			ps.setString(4, mdto.getTime());
			ps.setString(5, mdto.getApprove());
			ps.setString(6, mdto.getAgree());
			ps.setInt(7, mdto.getNum());
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

	public void delete(String num) {
		String sql = "delete emart where num=" + num;
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

	public void deleteSel(String[] selectDel) {
		String sql = "delete emart where num = ?";
		for(int i=1; i<selectDel.length; i++) {
			sql += " or num = ?";
		}
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql); 
			for(int i=0; i<selectDel.length; i++) {
				System.out.println(selectDel[i]);
				ps.setString(i+1, selectDel[i]);
			}
			cnt += ps.executeUpdate();
			System.out.println("deleteSel cnt : " + cnt);
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
