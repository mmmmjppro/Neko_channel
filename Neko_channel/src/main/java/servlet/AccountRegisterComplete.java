package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.AccountRegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;


@WebServlet("/AccountRegisterComplete")
public class AccountRegisterComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Sessionスコープからインスタンスの取得
		HttpSession session = request.getSession();
		AccountBeans newAccount = (AccountBeans)session.getAttribute("registerAccount");
		
		 //DAOを利用して新規登録
		AccountRegisterDAO dao =  new AccountRegisterDAO();
		
		String errorMsg = "";
        
        try {
            dao.accountRegister(newAccount);
            
         // セッションスコープからregisterAccountを削除
            session.removeAttribute("registerAccount");

            // 登録成功時のページ遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
            dispatcher.forward(request, response);
           
            
        } catch (IllegalArgumentException e) {
            
        	// 一意性制約違反時のエラーメッセージ
            errorMsg = "重複するユーザー名があります。別のユーザー名を入力してください。";
            request.setAttribute("errorMsg", errorMsg);
            
         // セッションスコープからregisterAccountを削除
            session.removeAttribute("registerAccount");

            // AccountRegisterサーブレットにフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerCheck.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException e) {
            // その他のSQLエラー
            errorMsg = "データベースエラーが発生しました。管理者にお問い合わせください。";
            request.setAttribute("errorMsg", errorMsg);
            
         // セッションスコープからregisterAccountを削除
            session.removeAttribute("registerAccount");

            // AccountRegisterサーブレットにフォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerCheck.jsp");
            dispatcher.forward(request, response);
        }
 }


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}



}
