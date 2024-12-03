package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.LikesLogic;

@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // パラメータの取得
        String mutterIdStr = request.getParameter("mutterId");
        HttpSession session = request.getSession();
        AccountBeans loginUser = (AccountBeans) session.getAttribute("loginUser");

        if (mutterIdStr == null || loginUser == null) {
            response.sendRedirect("Error.jsp");
            return;
        }

        try {
            int mutterId = Integer.parseInt(mutterIdStr);
            String userId = loginUser.getUserId(); // AccountBeansからuserIdを取得

            // いいね処理を実行
            LikesLogic likesLogic = new LikesLogic();
            boolean isSuccess = likesLogic.addLike(mutterId, userId);

            if (isSuccess) {
                response.sendRedirect("Main"); // 元のページにリダイレクト
            } else {
                response.sendRedirect("Error.jsp"); // エラー時はエラーページへ
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("Error.jsp");
        }
    }
}
