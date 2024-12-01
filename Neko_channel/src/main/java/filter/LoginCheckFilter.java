package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;


@WebFilter("/*") // 全リクエストを対象
public class LoginCheckFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // セッションスコープからユーザー情報を取得
        HttpSession session = request.getSession(false);
        AccountBeans loginUser = (session != null) ? (AccountBeans) session.getAttribute("loginUser") : null;

        // リクエストURIの取得
        String requestURI = request.getRequestURI();

        // ログイン不要なリソースのリスト
        boolean isLoginRequired = isLoginRequired(requestURI);

        if (isLoginRequired && loginUser == null) {
            // ログインが必要だが未ログインの場合、ログイン画面にリダイレクト
            response.sendRedirect("index.jsp");
            return; // フィルタチェーンを中断
        }

        // 次のフィルタまたはサーブレットに進む
        chain.doFilter(request, response);
    }

    /**
     * ログイン不要なリソースかどうかを判定するメソッド
     */
    private boolean isLoginRequired(String requestURI) {
        // ログイン不要なパスを定義
        String[] notRequiredPaths = {
            "index.jsp",                // トップページ
            "LoginServlet",             // ログイン処理
            "AccountRegister",          // 新規登録画面
            "AccountRegisterComplete",  // 新規登録確認
            ".css",                     
            ".js",                      
            ".png",                     
            ".jpg"                     
        };

        // ログイン不要なパスと一致するかをチェック
        for (String path : notRequiredPaths) {
            if (requestURI.endsWith(path)) {
                return false; // ログイン不要
            }
        }
        return true; // ログイン必要
    }
}

