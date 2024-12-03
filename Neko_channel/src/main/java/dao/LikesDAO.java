package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LikeBeans;

public class LikesDAO {
	// データベース接続情報
	   private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/OneDrive/Documents/SQL/Neko_DB";
	   private final String DB_USER = "sa";
	   private final String DB_PASS = "";
	   // JDBCドライバを読み込む
	   static {
	       try {
	           Class.forName("org.h2.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
	       }
	   }
	  
	   // 「いいね」を登録する
	   public boolean insertLike(LikeBeans like) throws SQLException {
	       String sql = "INSERT INTO likes (MUTTER_ID, USER_ID) VALUES (?, ?)";
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	           pstmt.setInt(1, like.getMutterId());
	           pstmt.setString(2, like.getUserId());
	           int rowsAffected = pstmt.executeUpdate();
	           return rowsAffected > 0; // 1行以上が影響を受けた場合は成功
	       }
	   }
	  
	  
	   // ある投稿に対する「いいね」の数を取得する
	   public int countLikes(int mutterId) throws SQLException {
	       String sql = "SELECT COUNT(*) AS like_count FROM likes WHERE MUTTER_ID = ?";
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	           pstmt.setInt(1, mutterId);
	           try (ResultSet rs = pstmt.executeQuery()) {
	               if (rs.next()) {
	                   return rs.getInt("like_count");
	               }
	           }
	       }
	       return 0;
	   }
	}
