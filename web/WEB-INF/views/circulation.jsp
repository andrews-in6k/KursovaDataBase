<%--
  Created by IntelliJ IDEA.
  User: ANRI
  Date: 16.12.2015
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обіг</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
<body id="framebody">
  <table align="center" class="table table-striped table-bordered">
    <th colspan="5">Обіг</th>

    <tr>
      <th>Дата зміни</th>
      <th>Кількість</th>
      <th>Одиниця виміру</th>
      <th>Назва товару</th>
      <th>Новий товар</th>
    </tr>

    <c:forEach var="circulation" items="${circulations}">
      <tr>
        <td align="center">${circulation.changeDate}</td>
        <td align="center">${circulation.changeAmount}</td>
        <td align="center">${circulation.goods.measureValue}</td>
        <td align="center">${circulation.goods.name}</td>
        <c:choose>
          <c:when test="${circulation.newOrNot == 0}">
            <td align="center">-</td>
          </c:when>
          <c:otherwise>
            <td align="center">+</td>
          </c:otherwise>
        </c:choose>
      </tr>
    </c:forEach>

  </table>
</body>
</html>
