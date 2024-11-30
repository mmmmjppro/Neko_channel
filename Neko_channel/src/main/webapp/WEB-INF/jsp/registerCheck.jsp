<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Neko channel</title>
</head>
<body>

<h1>Nekoちゃんねる</h1>
<h2>入力内容確認</h2>

    <!-- エラーメッセージの表示 -->
    <c:if test="${not empty errorMsg}">
        <p style="color: red;">${errorMsg}</p>
    </c:if>

	<!-- セッションスコープからデータを取得して表示 -->
	<p>猫ID: <c:out value="${sessionScope.registerAccount.userId}" /></p>
	<p>パスワード: <c:out value="${sessionScope.registerAccount.password}" /></p>
	<p>名前: <c:out value="${sessionScope.registerAccount.name}" /></p>
	<p>性別: <c:out value="${sessionScope.registerAccount.gender}" /></p>
	<p>血液型: <c:out value="${sessionScope.registerAccount.bloodType}" /></p>


    <!-- 登録ボタン -->
    <form action="AccountRegisterComplete" method="post">
        <input type="submit" value="登録する">
    </form>

    <!-- 修正ボタン -->
    <form action="AccountRegister" method="get">
        <input type="submit" value="登録画面へ戻る">
    </form>
</body>
</html>
</body>
</html>