<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/16/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table class="table">
  <thead>
  <tr>
    <th scope="col">ID</th>
    <th scope="col">Name</th>
    <th scope="col">Address</th>
    <th scope="col" colspan="1">Action</th>
    <th></th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${student}" var="student">
  <tr>
      <td>${student.getId()}</td>
      <td>${student.getName()}</td>
      <td>${student.getAddress()}</td>
      <td><a href="/home/showUpdate?id=${student.getId()}">Edit</a></td>
      <td><a href="/home/delete?id=${student.getId()}">Delete</a></td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/home/showCreate">Create</a>
</body>
</html>
