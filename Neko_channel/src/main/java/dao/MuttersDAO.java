package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MutterBeans;

public class MuttersDAO {
	
	//データベース接続に必要な情報
	String JDBC_URL = "jdbc:h2:tcp://localhost/~/desktop/Database/Neko";
	String DB_USER = "sa";
	String DB_PASS = "";
	
	//つぶやきを読み込むメソッド
	public List<MutterBeans> findAll() {
		
		List<MutterBeans> mutterList = new ArrayList<>();
		
		try{
			Class.forName("org.h2.Driver");
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){ 
			
			
			String sql = "SELECT ID,USER_ID,TEXT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userId = rs.getString("USER_ID");
				String text = rs.getString("TEXT");
				
				MutterBeans mutter = new MutterBeans(id,userId,text);
				mutterList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		return mutterList;
	}
	
	
	//つぶやきを作成するメソッド
	public boolean create(MutterBeans mutter) {
		
		try{
			Class.forName("org.h2.Driver");
		}catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBドライバを読み込めませんでした。");
		}
		
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){ 
			
			//Insert文の作成
			String sql = "INSERT INTO MUTTER(USER_ID,TEXT) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,mutter.getUserId());
			ps.setString(2, mutter.getText());
			
			int result = ps.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
