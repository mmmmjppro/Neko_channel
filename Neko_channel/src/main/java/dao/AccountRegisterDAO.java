package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountRegisterDAO {

	//データベースに接続する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/desktop/Database/Neko";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public void accountRegister(AccountBeans newAccount)
			throws SQLException{
		
		
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException
			("JDBCを読み込めませんでした");
		}
	
		//データベースに接続する
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO Users (USER_ID,PASS,NAME,GENDER,BLOOD_TYPE) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps= con.prepareStatement(sql);

			ps.setString(1, newAccount.getUserId());
			ps.setString(2, newAccount.getPassword());
			ps.setString(3, newAccount.getName());
			ps.setString(4, newAccount.getGender());
			ps.setString(5, newAccount.getBloodType());

			int result = ps.executeUpdate();

			if(result != 0) {
				System.out.println("新規登録成功！");
			} else {
				System.out.println("新規登録失敗( ﾉД`)ｼｸｼｸ…");
			}

		} catch (SQLException e) {
            // 一意性制約違反の検出
            if (e.getMessage().contains("Unique index or primary key violation")) {
                throw new IllegalArgumentException("既に使用されているUSER_IDです。");
            }
            throw e; // その他のSQL例外はそのままスロー
        }
    }
}