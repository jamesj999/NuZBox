<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
    <title>sup</title>
    <body>
        <p>You're in the admin page now brah...</p>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        	<h2>Welcome : ${pageContext.request.userPrincipal.name}
            <a href="<c:url value="logout" />" >Logout</a>
        </c:if>
    </body>
<html>
