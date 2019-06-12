<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp"/>

<h1>Task Dashboard</h1>

<table border="0">
    <tr>
        <td>
            <a href="add">Add new task</a>
        </td>
    </tr>

    <tr>
        <td>
            <a href="show">Show tasks</a>
        </td>
    </tr>

</table>
<table>
<tr>
    <td>
        <form action="/logout" method="post">
            <input type="submit" value="Logout"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </td>
</tr>

</table>

<jsp:include page="../footer.jsp"/>