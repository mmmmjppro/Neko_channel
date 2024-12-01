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
</head>
<body>

<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<h2>新規登録画面</h2>


<!-- エラーメッセージの表示 -->
<c:if test="${not empty errorMsg}">
    <p style="color: red;">${errorMsg}</p>
</c:if>

<form action="AccountRegister" method="post">
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
	<input type="radio" id="male" name="gender" value="男性">
	<label for="male">男性</label>
	<input type="radio" id="female" name="gender" value="女性">
	<label for="female">女性</label>
	<br>
	
	<label for="bloodType">血液型</label>
	<select id="bloodType" name="bloodType">
    <option value="A">A</option>
    <option value="B">B</option>
    <option value="O">O</option>
    <option value="AB">AB</option>
    <option value="不明">不明</option>
	</select>
        
    <input type="submit" value="登録内容を確認する"> 
</form>

　　<a href="index.jsp">TOPへ</a>

<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>