<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
欢迎：<span id="useraccount"></span>
<a href="/userregiterloginAction/toregiter">注册</a></br>
<a href="/userregiterloginAction/tologin">登录</a>
<a href="/userregiterloginAction/exit">退出登录</a>
<a href="/orderAction/queryorderbyuserid">订单查询</a>
<table border="2">
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.producttitle}</td>
            <td>${item.productpicture}</td>
            <td>${item.miaoshaprie}</td>
            <td>${item.originalprice}</td>
            <td>${item.starttime}</td>
            <td>${item.endtime}</td>
            <td><a href="viewproductdetail?id=${item.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>


<script type="text/javascript" src="${ctx}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $.ajax({
        type:"get",
        url:"/pagehomeAction/getuser",
        success:function (msg) {
            $("#useraccount").html(msg);
        }
    })
</script>
</body>
</html>