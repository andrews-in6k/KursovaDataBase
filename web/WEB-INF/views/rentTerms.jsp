<%--
  Created by IntelliJ IDEA.
  User: ANRI
  Date: 16.12.2015
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Терміни оренди</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
<body id="framebody">
  <table align="center" class="table table-striped table-bordered">
    <th colspan="4">Строки оренди</th>

    <tr>
      <th>Початок</th>
      <th>Кінець</th>
      <th>№ кімнати</th>
      <th>Орендар</th>
    </tr>

    <c:forEach var="rentTerm" items="${rentTerms}">
      <tr>
        <td align="center">${rentTerm.startDate}</td>
        <td align="center">${rentTerm.finishDate}</td>
        <td align="center">${rentTerm.room.roomNumber}</td>
        <td align="center">${rentTerm.renter.surname} ${rentTerm.renter.name}</td>
      </tr>
    </c:forEach>

  </table>
</body>
</html>
