package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {
	// 싱글톤패턴으로 , 생성자 1,2단계 ㄱㄱ
	private static FDao fdao;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "jspid";
	String dbpw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private FDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static FDao getInstance() {
		if(fdao == null) {
			fdao = new FDao();
		}
		return fdao;
	}

	public void insertFootball(FDto fdto) {
		String sql = "insert into football values(fb_seq.nextval, ?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fdto.getId());
			ps.setString(2, fdto.getPw());
			ps.setString(3, fdto.getWin());
			ps.setString(4, fdto.getRound16());
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

	public ArrayList<FDto> getAllFootball() {
		ArrayList<FDto> lists = new ArrayList<FDto>();
		String sql = "select * from football order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				FDto fd = new FDto();
				fd.setNum(rs.getInt("num"));
				fd.setId(rs.getString("id"));
				fd.setPw(rs.getString("pw"));
				fd.setWin(rs.getString("win"));
				fd.setRound16(rs.getString("round16"));
				lists.add(fd);
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

	public FDto getFootballByNum(String num) {
		FDto fd = new FDto();
		String sql = "select * from football where num=" + num;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				fd.setNum(rs.getInt("num"));
				fd.setId(rs.getString("id"));
				fd.setPw(rs.getString("pw"));
				fd.setWin(rs.getString("win"));
				fd.setRound16(rs.getString("round16"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fd;
	}

	public void updateFootball(FDto fd) {
		String sql = "update football set id=?, pw=?, win=?, round16=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd.getId());
			ps.setString(2, fd.getPw());
			ps.setString(3, fd.getWin());
			ps.setString(4, fd.getRound16());
			ps.setInt(5, fd.getNum());
			
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

	public void deleteFootball(String num) {
		String sql = "delete football where num=" + num;
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
