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
    <title>Кімнати</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
<body id="framebody">
  <table align="center" class="table table-striped table-bordered">
    <th colspan="4">Кімнати</th>

    <tr>
      <th>№ кімнати</th>
      <th>Розмір</th>
      <th>Орендар</th>
    </tr>

    <c:forEach var="room" items="${rooms}">
      <tr>
        <td align="center">${room.roomNumber}</td>
        <td align="center">${room.size}</td>
        <td align="center">${room.renter.surname} ${room.renter.name}</td>

        <form method="post" action="/rooms/${room.id}">
          <input type="hidden" name="_method" value="DELETE">
          <td align="center">
            <input type="image" src="/resources/images/icon-delete.gif" alt="del">
          </td>
        </form>
      </tr>
    </c:forEach>

  </table>

  <div align="center">
    <form method="post" action="/rooms">
      <table align="center" class="table">
        <tr>
          <td>
            <label for="number">Номер</label>
            <input type="number" name="number" id="number" value="0" class="form-control">
          </td>
          <td>
            <label for="size">Розмір</label>
            <input type="number" name="size" id="size" value="0" class="form-control">
          </td>
        </tr>

        <tr>
          <td colspan="3" align="right">
            <input type="submit" name="add" value="Додати"  class="btn btn-default">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
