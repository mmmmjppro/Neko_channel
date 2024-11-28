package model;

import java.io.Serializable;

public class AccountBeans implements Serializable {
    
    //DBの要素に合わせたフィールド
    private int accountNumber;
    private String userId;
    private String password;
    private String name;
    private String gender;
    private String bloodType;
    
    //Constructors 
    
    public AccountBeans() {}
    
    public AccountBeans(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
    
    public AccountBeans(int accountNumber, String userId, String password, String name, String gender, String bloodType) {
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.bloodType = bloodType;
    }
    
    //Getter and setter 
    
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }
}

