<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp"/>

<h1>Edit task</h1>
<table>
    <form:form method="post" action="/task/edit" modelAttribute="task">
        <form:hidden path="id"/>

        <tr>
            <td>User:</td>
            <td><form:select path="user.id" items="${userlist}" itemLabel="username" itemValue="id"/></td>
        </tr>
        <tr>
            <td>Task name:</td>
            <td><form:input path="name"/>
                <form:errors path="name"/>
            </td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input path="endDate"/>
                <form:errors path="endDate"/></td>
        </tr>
        <tr>
            <td>Priority:</td>
            <td><form:select path="priority.id" items="${prioritylist}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Save">
            </td>
        </tr>
    </form:form>
</table>
<jsp:include page="../footer.jsp"/>