package model;

import java.sql.SQLException;

import dao.AccountRegisterDAO;

public class RegisterLogic {
	public void execute(AccountBeans newAccount)
			throws SQLException, IllegalArgumentException {
        AccountRegisterDAO dao = new AccountRegisterDAO();

        // 登録処理を実行
        dao.accountRegister(newAccount);
    }
}
