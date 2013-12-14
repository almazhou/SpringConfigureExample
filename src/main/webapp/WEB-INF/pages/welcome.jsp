<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 11/27/13
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ex" uri="custom.tld"%>
<html>
<head>
    <title></title>
</head>
<body>
     <h1>${today}</h1>
     <form action="<%=request.getContextPath()%>/submitThis" method="post">
         <p>First name: <input type="text" name="fname" /></p>
         <p>Last name: <input type="text" name="lname" /></p>
         <input type="submit" value="Submit" />
     </form>
     <h2>Your first name is ${firstName}</h2>
     <h2>Your first name is ${lastName}</h2>
     <h2>
         Time spent is ${time}
     </h2>
     <script>alert("I'm script in jsp")</script>
     <ex:Hello/>
</body>
</html>