<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nekoちゃんねる[新規登録]</title>
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

<h2 class="english-title">🐾Register Your Account🐾</h2>

<main>
    <div class="main-content align-center">
        <!-- エラーメッセージの表示 -->
        <c:if test="${not empty errorMsg}">
            <p style="color: red;">${errorMsg}</p>
        </c:if>

        <form action="AccountRegister" method="post" class="form-wrapper registration-form">
            <label for="userId">猫ID</label>
            <input type="text" name="userId" placeholder="Userid...">
            <br>
            
            <label for="password">パスワード</label>
            <input type="password" name="pass" placeholder="Password">
            <br>
            
            <label for="name">名前</label>
            <input type="text" name="name" placeholder="Your name">
            <br>
            
            <label for="gender">性別</label>
            
            <div class="radio-group align-center">
                <label for="male" class="radio-label">
                    <input type="radio" id="male" name="gender" value="男性">
                    男性
                </label>
                <label for="female" class="radio-label">
                    <input type="radio" id="female" name="gender" value="女性">
                    女性
                </label>
            </div>
        
            <label for="bloodType">血液型</label>
            <select id="bloodType" name="bloodType">
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="O">O</option>
            <option value="AB">AB</option>
            <option value="不明">不明</option>
            </select>
            
            <br>
            <input type="submit" value="登録内容を確認する"> 

        </form>

        <a href="index.jsp" class="custom-button">TOPへ</a>
    </div>
</main>
<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>