<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加学生</title>
</head>
<body>
<p align="center">添加学生</p>
<div align="center"><a href="${pageContext.request.contextPath }/list.jsp">返回主页</a></div>
<div align="center">
    <form action="${pageContext.request.contextPath }/addServlet" method="post">
        <table width="30%" border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
            <tr>
                <td>学生编号</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td><input type="Date" name="birthday"></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" name="description"></td>
            </tr>
            <tr>
                <td>平均分</td>
                <td><input type="number" min=0 max=100 name="avgscore"></td>
            </tr>
            <tr align="left">
                <td>
                </td>
                <td>
                    <input type="submit" value="提交数据">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
