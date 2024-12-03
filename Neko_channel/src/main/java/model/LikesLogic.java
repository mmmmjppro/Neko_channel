package model;

import java.sql.SQLException;

import dao.LikesDAO;

public class LikesLogic {
    private final LikesDAO likesDAO;

    // コンストラクタでDAOを初期化
    public LikesLogic() {
        this.likesDAO = new LikesDAO();
    }

    // 指定された投稿IDの「いいね数」を取得
    public int getLikeCount(int mutterId) {
        try {
            return likesDAO.countLikes(mutterId);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // エラー時は0を返す
        }
    }

    // 「いいね」を追加（必要なら）
    public boolean addLike(int mutterId, String userId) {
        try {
            return likesDAO.insertLike(new LikeBeans(0, mutterId, userId));
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // エラー時は失敗として返す
        }
    }
}
