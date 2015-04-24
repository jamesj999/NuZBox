<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page session="false"%>

<html>

   <head>
   <title>Hello Spring MVC</title>
   </head>
   <body>
       <c:if test="${pageContext.request.userPrincipal.name != null}">
           	<h2>Logged in as: ${pageContext.request.userPrincipal.name}</h2>
            <c:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="post">
              <input type="submit" value="Log out" />
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
       </c:if>
      <h2>${testMessage}</h2>
      <a href="echo?echo=put%20something%20here">Try the echo</a><br>
      <a href="admin">Admin area</a><br>
      <a href="profile">Profile area</a>
   </body>
</html>