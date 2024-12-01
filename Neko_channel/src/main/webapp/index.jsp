<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nekoちゃんねる[TOP]</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<!-- Headerのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<main>
<h2>🐾Nekoちゃんねるへようこそ🐾</h2>

<p>
    ここは気軽に自由につぶやける、ゆる～い掲示板だよ！<br>
    「お腹すいた～」「今日は何食べようかな？」「週末はゴロゴロしたい...」<br>
    そんな気ままなつぶやきを猫みたいにポンっと残してみてね。
</p>

<p>
    深いことは考えず、のんびり気軽に。<br>
    つぶやいているうちに、ちょっと楽しくなるかも🐾<br>
    さぁ、あなたの「にゃー！」を届けてみよう！
</p>

<a href="LoginServlet">ログイン画面へ</a>
<a href="AccountRegister">新規登録</a>
</main>
<!-- フッターのインクルード -->
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />

</body>
</html>