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


@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// JSPファイルへのフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
	    dispatcher.forward(request, response);
	}   
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータの取得
		String userId = request.getParameter("userId");
		String password = request.getParameter("pass");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String bloodType = request.getParameter("bloodType");
				
		 // リクエストスコープに保存するエラーメッセージの初期化
        String errorMsg = "";

        // 入力チェック
        if (userId == null || userId.isEmpty() ||
            password == null || password.isEmpty() ||
            name == null || name.isEmpty() ||
            gender == null || gender.isEmpty() ||
            bloodType == null || bloodType.isEmpty()) {

            errorMsg = "全ての項目を入力してください。";
            request.setAttribute("errorMsg", errorMsg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
            dispatcher.forward(request, response);
            return;
            
        } else { //Sessionスコープに入力情報を保存し、確認画面にフォワード
        	
        	//登録前の仮アカウントとしてインスタンス生成
        	AccountBeans registerAccount = new AccountBeans(userId,password,name,gender,bloodType);
        	HttpSession session = request.getSession();
        	session.setAttribute("registerAccount",registerAccount);
        	
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerCheck.jsp");
            dispatcher.forward(request, response);
        }
	}
 
        
        
        

}
