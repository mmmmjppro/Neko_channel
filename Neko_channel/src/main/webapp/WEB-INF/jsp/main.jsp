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

<!-- Google font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Playfair+Display:ital,wght@0,400..900;1,400..900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Sawarabi+Gothic&display=swap" rel="stylesheet">
</head>
<body>
<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<h2 class="english-title">🐾The Meow Spot🐾</h2>

<div class="align-center">
    <a href="Main" class="sub-button">更新</a>
    <a href="Logout" class="sub-button">退出する</a>
</div>

<div style="position: relative; max-width: 600px; margin: 0 auto;">
    <img src="images/cat.png" alt="猫" class="cat-image">
    <form action="Main" method="post" class="form-wrapper tweet-form">
        <input type="text" name="text" placeholder="にゃにゃにゃ...">
        <input type="submit" value="にゃ～">
    </form>
</div>


<c:if test="${not empty errorMsg}">
    <p style="color: red;"><c:out value="${errorMsg}" /></p>
</c:if>

<div class="tweets-container">
    <c:forEach var="mutter" items="${mutterList}">
        <div class="tweet-wrapper">
            <p class="user-id"><c:out value="${mutter.userId}" /></p>
            <p class="tweet-text"><c:out value="${mutter.text}" /></p>
            <div class="tweet-actions">
                <!-- いいねの数を表示 -->
                <span><img class="likes" src="${pageContext.request.contextPath}/images/like.png" alt="LIKE"> <c:out value="${mutter.likeCount}" /></span>
                <!-- いいねボタン -->
                <form action="LikeServlet" method="post" class="like-form">
                    <input type="hidden" name="mutterId" value="${mutter.mutterId}" />
                    <button type="submit" class="like-button">いいね</button>
                </form>
            </div>
            <div class="tweet-divider"></div>
        </div>
    </c:forEach>
</div>

<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>