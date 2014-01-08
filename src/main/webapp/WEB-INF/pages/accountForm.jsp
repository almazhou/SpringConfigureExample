<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 1/8/14
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<%=request.getContextPath()%>/submitFirstForm" method="post" modelAttribute = "wizardForms">
    <input type="hidden" name="_page" value="1" />
    <input type="text" name="account" value="your account" />
    <input type="text" name="password" value="your password" />
    <input type="submit" name="_target0" value="Previous" />
    <input type="submit" name="_target2" value="Next" />
    <input type="submit" name="_cancel" value="Cancel" />
</form>
</body>
</html>
