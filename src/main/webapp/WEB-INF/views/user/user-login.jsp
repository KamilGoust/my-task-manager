<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../header.jsp"/>

<h1>Login user</h1>

<table border="0">
    <form method="post">
        <tr>
            <td>User:</td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>

        <tr>
            <td>Password:</td>
            <td>
                <input type="password" name="password"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Sign In"/>
            </td>
        </tr>
    </form>
</table>

<table border="0">
    <tr>
        <td>
            <a href="registration">Create new user</a>
        </td>
    </tr>
</table>


<jsp:include page="../footer.jsp"/>