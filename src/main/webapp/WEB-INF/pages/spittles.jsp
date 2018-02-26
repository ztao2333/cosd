<%--
  Created by IntelliJ IDEA.
  User: zhangtao
  Date: 2018/2/26
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>spittles</title>
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <li >
            ${spittle.message}
        </li>
    </c:forEach>
${spittle.message}
</body>
</html>
