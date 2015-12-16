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
        <td align="center"><a href="/renters/${renter.id}/edit"><img src="/resources/images/edit.png"></a></td>

        <form method="post" action="/renters/${renter.id}">
          <input type="hidden" name="_method" value="DELETE">
          <td align="center">
            <input type="image" src="/resources/images/icon-delete.gif" alt="del">
          </td>
        </form>
      </tr>

      <c:if test="${edit != null && edit == renter.id}">
        <form method="post" action="/renters/${renter.id}">
          <input type="hidden" name="_method" value="PUT">

          <tr>
            <td><input type="text" name="editRenterName" value="${renter.name}" class="form-control"></td>
            <td><input type="text" name="editRenterSurname" value="${renter.surname}" class="form-control"></td>
            <td><input type="number" name="editRenterPhoneNumber" value="${renter.phoneNumber}" class="form-control"></td>
            <td><input type="submit" name="save" value="Зберегти" class="btn btn-default"></td>
          </tr>

        </form>
      </c:if>
    </c:forEach>

  </table>

  <div align="center">
    <form method="post" action="/renters">
      <table align="center" class="table">
        <tr>
          <td>
            <label for="renterName">Ім’я</label>
            <input type="text" name="renterName" id="renterName" value="" class="form-control">
          </td>
          <td>
            <label for="renterSurname">Прізвище</label>
            <input type="text" name="renterSurname" id="renterSurname" value="" class="form-control">
          </td>
          <td>
            <label for="renterPhoneNumber">Номер телефону</label>
            <input type="number" name="renterPhoneNumber" id="renterPhoneNumber" class="form-control">
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
