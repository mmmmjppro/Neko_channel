<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nekoちゃんねる[掲示板]</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<h2>猫のたまり場</h2>

<a href="Main">更新</a>
<a href="Logout">退出する</a>

<form action="Main" method="post">
    <input type="text" name="text" placeholder="にゃにゃにゃ...">
    <input type="submit" value="にゃ～">
</form>

<c:if test="${not empty errorMsg}">
    <p style="color: red;"><c:out value="${errorMsg}" /></p>
</c:if>

<c:forEach var="mutter" items="${mutterList}">
    <p><c:out value="${mutter.userId}" />: <c:out value="${mutter.text}" /></p>
</c:forEach>

<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>