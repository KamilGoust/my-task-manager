<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>

<table border="0">

    <c:forEach items="${tasklist}" var="task">
        <tr>
            <td>
                Task ${task.id}:
            </td>
            <td>
                User: ${task.user.username},
            </td>
            <td>
                Name: ${task.name},
            </td>
            <td>
                Priority: ${task.priority.name},
            </td>
            <td>
                Ends: ${task.endDate}
            </td>
            <td>
                <a href="/done">Done</a>
            </td>
            <td>
                <a href="/task/edit/${task.id}">Edit</a>
            </td>
            <td>
                <a href="/task/delete/${task.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<table border="0">
    <tr>
        <td>
            <a href="/task/add">Add next task</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/task/dashboard">Dashboard</a>
        </td>
    </tr>
</table>


<jsp:include page="../footer.jsp"/>