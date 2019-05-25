<%@ page import="Dao.Student" %><%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2019/5/23
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");

%>
<form action="UpdateServlet">
    学号：<input type="text" name="sid" value="<%=student.getSid()%>" readonly="readonly"><br>
    姓名：<input type="text" name="sname" value="<%=student.getSname()%>"><br>
    年龄：<input type="text" name="sage" value="<%=student.getSage()%>"><br>
    地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>"><br>
    <input type="submit" value="修改"><a href="QueryAllStudentServlet">返回</a>
</form>
</body>
</html>
