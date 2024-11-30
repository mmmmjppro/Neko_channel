package servlet;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.RegisterLogic;


@WebServlet("/AccountRegisterComplete")
public class AccountRegisterComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープからインスタンスの取得
		HttpSession session = request.getSession();
		AccountBeans newAccount = (AccountBeans)session.getAttribute("registerAccount");
		
		// RegisterLogic を利用して登録処理を実行
        RegisterLogic registerLogic = new RegisterLogic();
        String errorMsg = "";
        
        try {
            registerLogic.execute(newAccount);
            
         // セッションスコープからregisterAccountを削除
            session.removeAttribute("registerAccount");

            // 登録成功時のページ遷移
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
            dispatcher.forward(request, response);
           
            
        } catch (IllegalArgumentException e) {
            
        	// DB制約違反時(PRI:ユーザ名重複のエラーメッセージ)
            errorMsg = "重複するユーザー名があります。別のユーザー名を入力してください。";
            request.setAttribute("errorMsg", errorMsg);
            
         // セッションスコープからregisterAccountを削除
            session.removeAttribute("registerAccount");

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerCheck.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException e) {
            // その他のSQLエラー(例：文字数が長すぎるなど）
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
