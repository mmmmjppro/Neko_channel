package test;

import model.AccountBeans;
import model.LoginLogic;

public class LoginLogicTest {

	public static void main(String[] args) {
		testExcecuteOK(); //ログイン成功のテスト
		testExcecuteNG(); //ログイン失敗のテスト
	}
	
	public static void testExcecuteOK() {
		AccountBeans loginAccount = new AccountBeans("Miwa","1234");
		LoginLogic bo = new LoginLogic();
		AccountBeans resultAccount = bo.execute(loginAccount);
		
		if(resultAccount != null) {
			System.out.println("testExceuteOK:成功★");
		} else {
			System.out.println("testExceuteOK:失敗");
		}
	}
	
	
	public static void testExcecuteNG() {
		AccountBeans loginAccount = new AccountBeans("Miwa","12345");
		LoginLogic bo = new LoginLogic();
		AccountBeans resultAccount = bo.execute(loginAccount);
		
		if (resultAccount == null) {
			System.out.println("testExceuteNG:成功★");
		} else {
			System.out.println("testExceuteNG:失敗");
		}
	}	
}
