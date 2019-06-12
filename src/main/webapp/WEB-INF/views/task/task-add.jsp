<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp"/>

<h1>Add task</h1>
<table border="0">
    <form:form method="post" modelAttribute="task">

        <tr>
            <td>User:</td>
            <td><form:select path="user.id" items="${userlist}" itemLabel="username" itemValue="id"/></td>
        </tr>
        <tr>
            <td>Task name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input path="endDate"/></td>
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

<table border="0">
    <tr>
        <td>
            <a href="/task/show">Show tasks</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/task/dashboard">Dashboard</a>
        </td>
    </tr>
</table>

<jsp:include page="../footer.jsp"/>