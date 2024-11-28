package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.LoginLogic;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//リクエストパラメータの取得
		String userId = request.getParameter("userId");
		String password = request.getParameter("pass");
		
		
	    // 入力の検証
	    if (userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
	        String errorMsg = "ユーザーIDまたはパスワードを入力してください。";
	        request.setAttribute("errorMsg", errorMsg);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }
		
		//ログイン処理の実行
		AccountBeans account = new AccountBeans(userId,password);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(account);
	
		String errorMsg = "";
				
		if (result) {
			//セッションスコープにユーザIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			//loginSuccess.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			 errorMsg = "ユーザーIDまたはパスワードが正しくありません。";
		     request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);	
		}
	}
}
