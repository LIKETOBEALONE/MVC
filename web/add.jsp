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
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    function check() {
        var sid = $("#sid").val();
        var sname = $("#sname").val();
        var sage = $("#sage").val();
        var saddress = $("#saddress").val();
        if (!sid > 0 && sid < 101) {
            alert("学号有误！1-100")
            return false;
        }
        if (!sname.length > 1 && sname < 5) {
            alert("姓名长度错误")
            return false;
        }

        return true;

    }
</script>
<body>
<form action="AddStudentServlet" method="post" onsubmit="return check()">
    学号：<input type="text" name="sid" id="sid"><br>
    姓名：<input type="text" name="sname" id="sname"><br>
    年龄：<input type="text" name="sage" id="sage"><br>
    地址：<input type="text" name="saddress" id="saddress"><br>
    <input type="submit" value="新增"><br>

</form>


</body>
</html>
