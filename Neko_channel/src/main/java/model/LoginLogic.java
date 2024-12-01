package model;

import dao.AccountsDAO;

public class LoginLogic {

	 public AccountBeans execute(AccountBeans loginAccount) {
	        AccountsDAO dao = new AccountsDAO();
	        return dao.findAccount(loginAccount); // アカウント情報を返す
	}
}
