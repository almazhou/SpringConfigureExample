<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 11/27/13
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ex" uri="custom.tld"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title><spring:message code="welcome.title" text="Welcome"/></title>
</head>
<body>
     <h2><spring:message code="welcome.message" text="Welcome to Germany"/></h2>
     <h1>${today}</h1>
     <form action="<%=request.getContextPath()%>/submitThis" method="post">
         <p>First name: <input type="text" name="fname" /></p>
         <p>Last name: <input type="text" name="lname" /></p>
         <input type="submit" value="Submit" />
     </form>
     <h2>Your first name is ${firstName}</h2>
     <h2>Your first name is ${lastName}</h2>
     <h2>
         Time spent is $    {time}
     </h2>
     <ex:Hello/>
     Locale:${pageContext.response.locale}

    <tags:merry firstName = "zhouxuan"
             />
</body>
</html>