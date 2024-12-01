<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nekoちゃんねる[ログイン]</title>
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
        <h2 class="english-title">🐾 Meow! Please Log In 🐾</h2>

        <c:if test="${not empty errorMsg}">
            <p style="color: red;">${errorMsg}</p>
        </c:if>
        <form action="LoginServlet" method="post" class="form-wrapper login-form">
            <label for="userId">猫ID</label>
            <input type="text" name="userId" placeholder="Userid...">
            <br>
            
            <label for="password">パスワード</label>
            <input type="password" name="pass" placeholder="Your password">
            <br>
            
            <input type="submit" value="ログイン" class="custom-button"> 
        </form>
    </div>
</main>

<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>