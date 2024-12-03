package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.GetMutterListLogic;
import model.LikesLogic;
import model.MutterBeans;
import model.PostMutterLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // つぶやきリストを取得
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<MutterBeans> mutterList = getMutterListLogic.execute();

        // いいね数を取得して設定
        LikesLogic likesLogic = new LikesLogic();
        for (MutterBeans mutter : mutterList) {
            int likeCount = likesLogic.getLikeCount(mutter.getMutterId());
            mutter.setLikeCount(likeCount);
        }

        // リクエストスコープに保存
        request.setAttribute("mutterList", mutterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String text = request.getParameter("text");

        if (text != null && text.length() != 0) {
            HttpSession session = request.getSession();
            AccountBeans loginUser = (AccountBeans) session.getAttribute("loginUser");

            // つぶやきをリストに追加
            MutterBeans mutter = new MutterBeans(loginUser.getUserId(), text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter);
        } else {
            request.setAttribute("errorMsg", "何かつぶやいてにゃ");
        }

        // つぶやきリストを取得し、リクエストスコープに保存
        GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        List<MutterBeans> mutterList = getMutterListLogic.execute();

        LikesLogic likesLogic = new LikesLogic();
        for (MutterBeans mutter : mutterList) {
            int likeCount = likesLogic.getLikeCount(mutter.getMutterId());
            mutter.setLikeCount(likeCount);
        }

        request.setAttribute("mutterList", mutterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    }
}
