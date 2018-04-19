
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<p align="center">修改学生</p>
<div align="center"><a href="${pageContext.request.contextPath }/queryServlet">返回主页</a></div>
<div align="center">
    <form action="${pageContext.request.contextPath }/addServlet?id=${requestScope.student.id }" method="post">
        <table width="30%" border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
            <tr>
                <td>学生编号</td>
                <td><input type="text" name="id"  readonly="readonly" value="${requestScope.student.id}"></td>
            </tr>
            <tr>
                <td>学生姓名</td>
                <td><input type="text" name="name" value="${requestScope.student.name}"></td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td><input type="text" name="birthday"  value="${requestScope.student.birthday}"></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" name="description"  value="${requestScope.student.description}"></td>
            </tr>
            <tr>
                <td>平均分</td>
                <td><input type="text" name="avgscore"   value="${requestScope.student.avgscore}"></td>
            </tr>
            <tr align="left">
                <td>
                </td>
                <td>
                    <input type="submit" value="确认修改">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
