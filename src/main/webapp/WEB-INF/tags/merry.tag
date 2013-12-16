<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="firstName" required="true"%>
<br/>
<h1>Hi,${firstName},you are in a tag file now.</h1>
<jsp:doBody/>