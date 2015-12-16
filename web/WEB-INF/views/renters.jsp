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
    <title>Орендарі</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
<body id="framebody">
  <table align="center" class="table table-striped table-bordered">
    <th colspan="5">Орендарі</th>

    <tr>
      <th>Ім’я</th>
      <th>Прізвище</th>
      <th>Номер телефону</th>
    </tr>

    <c:forEach var="renter" items="${renters}">
      <tr>
        <td align="center">${renter.name}</td>
        <td align="center">${renter.surname}</td>
        <td align="center">${renter.phoneNumber}</td>
        <td align="center">edit</td>
        <td align="center">delete</td>
      </tr>
    </c:forEach>

  </table>
</body>
</html>
