package model;

import java.io.Serializable;

public class LikeBeans implements Serializable{

	private int id;           // LIKEの一意のID
    private int mutterId;     // MUTTERのID
    private String userId;    // LIKEしたユーザーのID
    
 // コンストラクタ（
    public LikeBeans() {}
    
    public LikeBeans(int mutterId, String userId) {
    	this.mutterId = mutterId;
        this.userId = userId;
    }

    public LikeBeans(int id, int mutterId, String userId) {
        this.id = id;
        this.mutterId = mutterId;
        this.userId = userId;
	}
    
    
 // Getter and Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMutterId() { return mutterId; }
    public void setMutterId(int mutterId) { this.mutterId = mutterId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
 // toStringメソッド（デバッグ用）
    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                ", mutterId=" + mutterId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
