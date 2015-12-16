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

  <div align="center">
    <form method="post" action="/circulation">
      <table align="center" class="table">
        <tr>
          <td>
            <label for="changeDate">Дата зміни</label>
            <input type="date" name="changeDate" id="changeDate" class="form-control">
          </td>
          <td>
            <label for="amount">Кількість</label>
            <input type="number" name="amount" id="amount" value="0" class="form-control">
          </td>
          <td>
            <label for="newOrNot">Новий</label>
            <br>
            <input type="radio" name="new" value="yes" id="newOrNot">Так
            <br>
            <input type="radio" name="new" value="no" checked="checked">Ні
          </td>
          <td>
            <label for="goodsSelect">Товар</label>
            <select size="1" name="goodsSelect" id="goodsSelect" class="form-control">
              <c:forEach var="good" items="${goods}">
                <option value="${good.id}">${good.name}</option>
              </c:forEach>
            </select>
          </td>
        </tr>

        <tr>
          <td>
            <label for="goodsName">Назва товару</label>
            <input type="text" name="goodsName" id="goodsName" value="" class="form-control">
          </td>
          <td>
            <label for="measureValue">Одиниця виміру</label>
            <input type="text" name="measureValue" id="measureValue" value="" class="form-control">
          </td>
          <td>
            <label for="roomSelect">Кімната</label>
            <select size="1" name="roomSelect" id="roomSelect" class="form-control">
              <c:forEach var="room" items="${rooms}">
                <option value="${room.id}">${room.roomNumber}</option>
              </c:forEach>
            </select>
          </td>
        </tr>

        <tr>
          <td colspan="4" align="right">
            <input type="submit" name="add" value="Додати"  class="btn btn-default">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
