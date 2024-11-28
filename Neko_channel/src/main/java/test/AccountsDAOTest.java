package test;

import dao.AccountsDAO;
import model.AccountBeans;

public class AccountsDAOTest {
	public static void main(String[] args) {
		testFindAccountOK();//アカウントが見つかるテスト
		testFindAccountNG();//アカウントが見つからない場合のテスト
		
		
	}

	public static void testFindAccountOK() {
		AccountBeans account = new AccountBeans("Miwa","1234");
		AccountsDAO dao = new AccountsDAO();
		AccountBeans result = dao.findAccount(account);
		if (result != null && result.getAccountNumber()==1 &&
			result.getUserId().equals("Miwa") &&
			result.getPassword().equals("1234") &&
			result.getName().equals("Miwa Miyako")&&
			result.getGender().equals("女性")&&
			result.getBloodType().equals("O")) {
			System.out.println("testFindAccountOK:成功★");
		} else {
			System.out.println("testFindAccountOK:失敗。");

		}
	}
	
	public static void testFindAccountNG() {
		AccountBeans account = new AccountBeans("Miwa","12345"); 
		AccountsDAO dao = new AccountsDAO();
		AccountBeans result = dao.findAccount(account);
		
		if (result == null) {
			System.out.println("testFindAccountNG:成功★");
		}else {
			System.out.println("testFindAccountNG:失敗");
		}
		
	}
}
