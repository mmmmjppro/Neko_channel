package model;

import java.io.Serializable;

public class MutterBeans implements Serializable {

	private int mutterId;
	private String userId;
	private String text;
	
	//Constructor
	public MutterBeans() {};
	
	public MutterBeans(String userId, String text) {
		this.userId =userId;
		this.text = text;
	}
	
	public MutterBeans(int mutterId, String userId, String text) {
		this.mutterId = mutterId;
		this.userId = userId;
		this.text = text;
	}
	
	//getter and setter 
	
	public int getMutterId() {
		return this.mutterId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
