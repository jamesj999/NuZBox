<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page session="false"%>

<html>

   <head>
   <title>Hello Spring MVC</title>
   </head>
   <body>
       ${article}
       <c:choose>
           <c:when test="${pageContext.request.userPrincipal.name != null}">
                <h2>Logged in as: ${pageContext.request.userPrincipal.name}</h2>
                <c:url var="logoutUrl" value="/logout"/>
                <form action="${logoutUrl}" method="post">
                  <input type="submit" value="Log out" />
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
           </c:when>
           <c:otherwise>
                <h2>You're not logged in</h2>
                                <c:url var="loginUrl" value="/login"/>
                                <form action="${loginUrl}" method="post">
                                  User: <input type="text" name="username" />
                                  Pass: <input type="password" name="password" />
                                  <input type="submit" value="Log In" />
                                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
           </c:otherwise>
       </c:choose>
      <h2>${testMessage}</h2>
      <a href="echo?echo=put%20something%20here">Try the echo</a><br>
      <a href="admin">Admin area</a><br>
      <a href="profile">Profile area</a>
   </body>
</html>