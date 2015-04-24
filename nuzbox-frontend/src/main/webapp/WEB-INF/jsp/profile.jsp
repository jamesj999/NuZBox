<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

Sup, welcome to the profile page...<br>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        	<h2>Welcome : ${pageContext.request.userPrincipal.name}
            <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="post">
              <input type="submit" value="Log out" />
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </c:if>