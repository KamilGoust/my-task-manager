<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp"/>

<h1>New user</h1>

<table border="0">
    <form:form method="post" modelAttribute="adduser">

        <tr>
            <td>User:</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Register">
            </td>
        </tr>
    </form:form>
</table>

<table border="0">
    <tr>
        <td>
            <a href="login">Back</a>
        </td>
    </tr>
</table>

<jsp:include page="../footer.jsp"/>