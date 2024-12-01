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
</head>
<body>

<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<h2>ログイン</h2>

<c:if test="${not empty errorMsg}">
    <p style="color: red;">${errorMsg}</p>
</c:if>
<form action="LoginServlet" method="post">
    <label for="userId">猫ID</label>
    <input type="text" name="userId" placeholder="Userid...">
    <br>
    
    <label for="password">パスワード</label>
    <input type="password" name="pass" placeholder="Your password">
    <br>
    
    <input type="submit" value="ログイン"> 
</form>

<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>