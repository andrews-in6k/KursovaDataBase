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
    <title>Товари</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/styles/style.css">
</head>
<body id="framebody">
  <table align="center" class="table table-striped table-bordered">
    <th colspan="6">Товари</th>

    <tr>
      <th>Назва</th>
      <th>Кількість</th>
      <th>Одиниця виміру</th>
      <th>№ кімнати</th>
    </tr>

    <c:forEach var="good" items="${goods}">
      <tr>
        <td align="center">${good.name}</td>
        <td align="center">${good.amount}</td>
        <td align="center">${good.measureValue}</td>
        <td align="center">${good.room.roomNumber}</td>
        <td align="center"><a href="/goods/${good.id}/edit"><img src="/resources/images/edit.png"></a> </td>

        <form method="post" action="/goods/${good.id}">
          <input type="hidden" name="_method" value="DELETE">
          <td align="center">
            <input type="image" src="/resources/images/icon-delete.gif" alt="del">
          </td>
        </form>

      </tr>

      <c:if test="${edit != null && edit == good.id}">
        <form method="post" action="/goods/${good.id}">
          <input type="hidden" name="_method" value="PUT">

          <tr>
            <td><input type="text" name="goodsName" value="${good.name}" class="form-control"></td>
            <td></td>
            <td><input type="text" name="measureValue" value="${good.measureValue}" class="form-control"></td>
            <td>
              <select size="1" name="roomSelect" class="form-control">
                <c:forEach var="room" items="${rooms}">
                  <option value="${room.id}">${room.roomNumber}</option>
                </c:forEach>
              </select>
            </td>
            <td><input type="submit" name="save" value="Зберегти" class="btn btn-default"></td>
          </tr>

        </form>
      </c:if>
    </c:forEach>

  </table>
</body>
</html>
