package model;

import dao.AccountsDAO;

public class LoginLogic {

	public boolean execute(AccountBeans loginAccount) {
		AccountsDAO dao = new AccountsDAO();
		AccountBeans account = dao.findAccount(loginAccount);
		
		return account != null;
		
	}
}
