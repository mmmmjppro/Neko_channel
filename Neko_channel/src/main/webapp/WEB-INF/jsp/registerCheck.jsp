<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nekoちゃんねる[登録情報確認]</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<!-- Google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Playfair+Display:ital,wght@0,400..900;1,400..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Sawarabi+Gothic&display=swap" rel="stylesheet">

</head>
<body>

<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<main>
    <div class="main-content">
        <h2 class="english-title">🐾Confirm Your Information🐾</h2>

        <!-- エラーメッセージの表示 -->
        <c:if test="${not empty errorMsg}">
            <p style="color: red;">${errorMsg}</p>
        </c:if>

        <div class="register-check">
            <div class="content">
                <p><strong>猫ID:</strong> test3</p>
                <p><strong>パスワード:</strong> 1234</p>
                <p><strong>名前:</strong> TEST</p>
                <p><strong>性別:</strong> 女性</p>
                <p><strong>血液型:</strong> A</p>
            </div>
            <form action="AccountRegisterComplete" method="post">
                <input type="submit" value="登録する">
            </form>
        </div>
        
        <form action="AccountRegister" method="get" class="align-center">
            <input type="submit" value="登録画面へ戻る" class="sub-button">
        </form>
    </div>
</main>   
<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>