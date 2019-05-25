<%@ page import="Dao.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2019/5/22
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("tr:odd").css("background-color", "blue")

        });
    </script>
    <title>学生信息列表</title>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
        if (error.equals("error")) {
            out.println("增加失败");

        } else if (error.equals("without")) {
            out.println("增加成功");
        }
    }
%>
<table border="1px">
    <tr>
        <th> 学号</th>
        <th> 姓名</th>
        <th> 年龄</th>
        <th>操作</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("student");
        for (Student s : students) {
    %>
    <tr>
        <td><a href="QueryStudentBySidServlet?sid=<%=s.getSid()%>"><%=s.getSid()%>
        </a>
        </td>
        <td><%=s.getSname()%>
        </td>
        <td><%=s.getSage()%>
        </td>

        <td><a href="DeleteServlet?sid=<%=s.getSid()%>">删除</a></td>
    </tr>
    <%
        }

    %>

</table>
<a href="add.jsp">新增</a>
</body>
</html>
