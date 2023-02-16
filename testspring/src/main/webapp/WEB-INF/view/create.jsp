<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/16/2023
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/home/create" method="post">
    <div class="mb-3">
        <label for="id" class="form-label">ID</label>
        <input name="id" type="text" class="form-control" id="id" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input name="name" type="text" class="form-control" id="name">
    </div>
    <div class="mb-3">
        <label class="form-check-label" for="address">Address</label>
        <input name="address" type="text" class="form-control" id="address">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
