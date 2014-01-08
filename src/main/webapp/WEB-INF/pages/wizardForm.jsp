<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 1/8/14
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="<%=request.getContextPath()%>/submitFirstForm" method="post" modelAttribute = "wizardForms">
    <input type="hidden" name="_page" value="0" />
    <input type="text" name="firstName" value="your first name" />
    <input type="text" name="lastName" value="your last name" />
    <input type="submit" name="_target1" value="Next" />
    <input type="submit" name="_cancel" value="Cancel" />
</form>
</body>
</html>
