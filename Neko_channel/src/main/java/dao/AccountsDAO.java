package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountsDAO {
	
	//データベースに接続する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/OneDrive/Documents/SQL/Neko_DB";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	//ログインアカウントを探す
	public AccountBeans findAccount(AccountBeans ab) {
		
		//戻り値の用意(Instanseの生成）
		AccountBeans returnAb = new AccountBeans();
		
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException
			("JDBCを読み込めませんでした");
		}
		
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){
			
			//SQL文を準備
			String sql = "SELECT ACCOUNT_NO, USER_ID,PASS,NAME,GENDER,BLOOD_TYPE FROM Users WHERE USER_ID = ? AND PASS = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,ab.getUserId());
			ps.setString(2, ab.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				//見つかったアカウント情報を戻り値にセット
				returnAb.setAccountNumber(rs.getInt("ACCOUNT_NO"));
				returnAb.setUserId(rs.getString("USER_ID"));
				returnAb.setPassword(rs.getString("PASS"));
				returnAb.setName(rs.getString("NAME"));
				returnAb.setGender(rs.getString("GENDER"));
				returnAb.setBloodType(rs.getString("BLOOD_TYPE"));		
			} else {
				//アカウントがなければnullを返す
				return null;
			}
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
			return returnAb;		
	}
	
}
