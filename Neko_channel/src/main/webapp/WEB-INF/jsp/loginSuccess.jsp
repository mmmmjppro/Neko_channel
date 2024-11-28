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

<h2>🐾<c:out value="${userId}" />猫さん、おかえりなさい🐾</h2>

<p>何かつぶやきますか～？&#x1f408;</p>

<a href="Main" >猫のたまり場にGO</a>
</body>
</html>