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
<p align="center">学生管理系统</p>
<div align="center" ><a href="${pageContext.request.contextPath }/add.jsp"  >添加学生</a></div>
<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>出生日期</td>
        <td>备注</td>
        <td>平均分</td>
        <td>操作</td>
    </tr>
    <!-- 迭代数据 -->
    <c:choose>
        <c:when test="${not empty requestScope.map}">
            <c:forEach var="emp" items="${requestScope.map}" varStatus="vs">
                <tr>
                    <td>${emp.value.id }</td>
                    <td>${emp.value.name }</td>
                    <td>${emp.value.birthday }</td>
                    <td>${emp.value.description }</td>
                    <td>${emp.value.avgscore }</td>
                    <td><a href="${pageContext.request.contextPath }/updateServlet?id=${emp.value.id }" >修改</a>
                        <a href="${pageContext.request.contextPath }/deleteServlet?id=${emp.value.id }">删除</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>
          <td colspan="7">对不起，没有你要找的数据</td>
            </tr>
        </c:otherwise>
    </c:choose>
    <tr>
        <td colspan="7" align="center">
            当前${requestScope.currentPage }/${requestScope.totalPage }页     &nbsp;&nbsp;
            <a href="${pageContext.request.contextPath }/queryServlet?currentPage=1">首页</a>
            <a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.currentPage-1}">上一页 </a>
            <a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.currentPage+1}">下一页 </a>
            <a href="${pageContext.request.contextPath }/queryServlet?currentPage=${requestScope.totalPage}">末页</a>
        </td>
    </tr>
</table>
</body>
</html>
