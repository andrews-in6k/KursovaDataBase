<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ANRI
  Date: 15.12.2015
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html id="indexHtml">
  <head>
    <title>Склад</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/styles/style.css">
    <script src="/resources/js/jquery.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script>
      function myFunc ()
      {
        document.getElementById ('iframe').style.height = window.frames ['iframe'].document.body.offsetHeight + 50 + 'px';
      }
    </script>
  </head>
  <body id="indexBody" class="indexBody">
  <div class="container">
    <nav class="navbar navbar-default">
      <div class="container-fluid">

        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Склад</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Обіг<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/circulation" target="iframe">Обіг</a></li>
                <li><a href="#" target="iframe">Товари</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Оренда<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#" target="iframe">Орендарі</a></li>
                <li><a href="#" target="iframe">Строки оренди</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Кімнати<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#" target="iframe">Кімнати</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <iframe src="/circulation" name="iframe" id="iframe" width="100%" onload="myFunc()"></iframe>

  </div>
  </body>
</html>
